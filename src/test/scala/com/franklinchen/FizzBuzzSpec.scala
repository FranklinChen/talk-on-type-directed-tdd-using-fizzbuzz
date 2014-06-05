package com.franklinchen

import org.specs2._
import org.scalacheck._
import org.scalacheck.Prop._

import FizzBuzz._
import ArbitraryConfig._

/** For original FizzBuzz and FizzBuzz with config. */
trait FizzBuzzSpec extends Specification
    with ScalaCheck { def is = s2"""
  ${evaluate(15) ==== "FizzBuzz"}
  ${evaluate(20) ==== "Buzz"}
  ${evaluate(6) ==== "Fizz"}
  ${evaluate(17) ==== "17"}

  ${`Multiple of both 3 and 5 => "FizzBuzz"`}
  ${`Multiple of only 3 => "Fizz"`}
  ${`Multiple of only 5 => "Buzz"`}
  ${`Not a multiple of either 3 or 5 => number`}

  ${`Arbitrary pair of divisors: divisible by first`}
  """

  def evaluate: Evaluator

  def `Multiple of both 3 and 5 => "FizzBuzz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 == 0) ==>
      { evaluate(i) ==== "FizzBuzz" }
    }.set(maxDiscardRatio = 100)

  def `Multiple of only 3 => "Fizz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 != 0) ==>
      { evaluate(i) ==== "Fizz" }
    }.set(maxDiscardRatio = 100)

  def `Multiple of only 5 => "Buzz"` =
    prop { i: Int => (i % 3 != 0 && i % 5 == 0) ==>
      { evaluate(i) ==== "Buzz" }
    }.set(maxDiscardRatio = 100)

  def `Not a multiple of either 3 or 5 => number` =
    prop { i: Int => (i % 3 != 0 && i % 5 != 0) ==>
      { evaluate(i) ==== i.toString }
    }.set(maxDiscardRatio = 100)

  def `Arbitrary pair of divisors: divisible by first` =
    arbitraryConfig { config: Config =>
      val evaluate = FizzBuzz.compile(config)
      // TODO: non-exhaustive
      val Config(Seq((d1, w1), (d2, _))) = config
      prop { i: Int => (i % d1 == 0 && i % d2 != 0) ==>
        { evaluate(i) ==== w1 }
      }
    }.set(maxDiscardRatio = 1000)
}
