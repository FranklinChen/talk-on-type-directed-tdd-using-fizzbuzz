package com.franklinchen

import scalaz._
import Scalaz._

import scala.collection.par._
import Scheduler.Implicits.global

import Utils.addOption

/** Implementations of FizzBuzz algorithm. */
object FizzBuzz {
  type Evaluator = Int => String

  val DIVISOR_MIN = 2
  val DIVISOR_MAX = 100

  def validatePair(pair: (Int, String)) = pair match {
    case (d, _) =>
      require(d >= DIVISOR_MIN,
        s"divisor $d must be >= $DIVISOR_MIN")
      require(d <= DIVISOR_MAX,
        s"divisor $d must be <= $DIVISOR_MAX")
  }

  case class Config(pairs: Seq[(Int, String)]) {
    pairs.foreach(validatePair)
  }

  type Compiler = Config => Evaluator

  type Rule = Int => Option[String]

  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => {
      i =>
      (i % n == 0).option(word)
    }
  }

  val compile: Compiler = { case Config(pairs) =>
      // Precompute, hence "compiler".
      val rules: Seq[Rule] = pairs.map(buildRule)

      // Return an Evaluator.
      { i =>
        val wordOptions: Seq[Option[String]] =
          rules.map{ rule => rule(i) }
        val combinedOption: Option[String] =
// Using Scalaz
//          wordOptions.reduce { (x, y) => x |+| y }
          wordOptions.reduce(addOption)
        combinedOption.getOrElse(i.toString)
      }
  }

  val parallelCompile: Compiler = { case Config(pairs) =>
      val rules = pairs.
        toArray.
        toPar.
        map(buildRule)

      { i: Int => rules.
        map { rule => rule(i) }.
        reduce(addOption).
        getOrElse(i.toString)
      }
  }

  /** Only works for 2. */
  val nonExhaustiveCompile: Compiler = {
    case Config(Seq((d1, w1), (d2, w2))) =>
      // Precompute, hence "compiler".
      val w = w1 + w2

      // Return an Evaluator.
      { i =>
        (i % d1 == 0, i % d2 == 0) match {
          case (true,  false) => w1
          case (false, true)  => w2
          case (true,  true)  => w
          case (false, false) => i.toString
        }
      }
    case _ => // TODO handle more than 2
      { i =>
        ???
      }
  }
}
