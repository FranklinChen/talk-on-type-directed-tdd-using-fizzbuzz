package com.franklinchen

import scala.collection.par._
import Scheduler.Implicits.global

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
    pairs foreach validatePair
  }

  type Compiler = Config => Evaluator

  type Rule = Int => Option[String]

  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => {
      i =>
      if (i % n == 0)
        Some(word)
      else
        None
    }
  }

  val compile: Compiler = {
    case Config(pairs) =>
      // Precompute, hence "compiler".
      val rules: Seq[Rule] = pairs map buildRule

      // Return an Evaluator.
      { i =>
        val words: Seq[Option[String]] =
          rules map { rule => rule(i) }
        val combinedWords: Option[String] =
          words reduce addOption
        combinedWords getOrElse i.toString
      }
  }

  val parallelCompile: Compiler = {
    case Config(pairs) =>
      val rules = pairs.toArray.
        toPar.
        map(buildRule)

      { i: Int => rules.
        map(rule => rule(i)).
        reduce(addOption).
        getOrElse(i.toString)
      }
  }

  def addOption(a1: Option[String],
                a2: Option[String])
      : Option[String] = (a1, a2) match {
    case (Some(s1), None)     => Some(s1)
    case (None,     Some(s2)) => Some(s2)
    case (Some(s1), Some(s2)) => Some(s1 + s2)
    case (None,     None)     => None
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

  val badEvaluate: Evaluator = { i =>
    if (i % 3 == 0)
      "Fizz"
    else if (i % 5 == 0)
      "Buzz"
    else if (i % 3 == 0 && i % 5 == 0)
      "FizzBuzz"
    else
      i.toString
  }
}
