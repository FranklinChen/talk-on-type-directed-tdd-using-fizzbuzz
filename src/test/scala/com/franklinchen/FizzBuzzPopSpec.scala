package com.franklinchen

import org.specs2._
import org.scalacheck._
import org.scalacheck.Prop._

import FizzBuzz._
import ArbitraryConfig._

trait FizzBuzzPopSpec extends Specification
    with ScalaCheck { def is = s2"""
  ${evaluate(2) ==== "2"}
  ${evaluate(21) ==== "FizzPop"}
  ${evaluate(9) ==== "Fizz"}
  ${evaluate(7) ==== "Pop"}
  ${evaluate(35) ==== "BuzzPop"}

  ${`Arbitrary triple of divisors: divisible by first`}
  """

  def evaluate: FizzBuzz.Evaluator

  def `Arbitrary triple of divisors: divisible by first` =
    arbitraryTripleConfig { config: Config =>
      val evaluate = FizzBuzz.compile(config)
      // TODO: non-exhaustive
      val Config(Seq((d1, w1), (d2, _), (d3, _))) = config
      prop { i: Int =>
        (i % d1 == 0 && i % d2 != 0 && i % d3 != 0) ==>
        { evaluate(i) ==== w1 }
      }
    }.set(maxDiscardRatio = 10000)
}
