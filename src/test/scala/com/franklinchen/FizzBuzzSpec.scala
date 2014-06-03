package com.franklinchen

import org.specs2._
import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import org.scalacheck.Prop._

import FizzBuzz._

class FizzBuzzSpec extends Specification
    with ScalaCheck { def is = s2"""
  ${Defaults.fizzBuzzer(15) ==== "FizzBuzz"}
  ${Defaults.fizzBuzzer(20) ==== "Buzz"}
  ${Defaults.fizzBuzzer(6) ==== "Fizz"}
  ${Defaults.fizzBuzzer(17) ==== "17"}

  ${`Multiple of both 3 and 5 => "FizzBuzz"`}
  ${`Multiple of only 3 => "Fizz"`}
  ${`Multiple of only 5 => "Buzz"`}
  ${`Not a multiple of either 3 or 5 => number`}

  ${Defaults.fizzBuzzPopper(2) ==== "2"}
  ${Defaults.fizzBuzzPopper(21) ==== "FizzPop"}
  ${Defaults.fizzBuzzPopper(9) ==== "Fizz"}
  ${Defaults.fizzBuzzPopper(7) ==== "Pop"}
  ${Defaults.fizzBuzzPopper(35) ==== "BuzzPop"}

  ${`Arbitrary pair of divisors: divisible by first`}
  """

  def `Multiple of both 3 and 5 => "FizzBuzz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 == 0) ==>
      { Defaults.fizzBuzzer(i) ==== "FizzBuzz" }
    }.set(maxDiscardRatio = 30)

  def `Multiple of only 3 => "Fizz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 != 0) ==>
      { Defaults.fizzBuzzer(i) ==== "Fizz" }
    }.set(maxDiscardRatio = 30)

  def `Multiple of only 5 => "Buzz"` =
    prop { i: Int => (i % 3 != 0 && i % 5 == 0) ==>
      { Defaults.fizzBuzzer(i) ==== "Buzz" }
    }.set(maxDiscardRatio = 30)

  def `Not a multiple of either 3 or 5 => number` =
    prop { i: Int => (i % 3 != 0 && i % 5 != 0) ==>
      { Defaults.fizzBuzzer(i) ==== i.toString }
    }.set(maxDiscardRatio = 30)

  // TODO: need to generalize to more than 2
  val arbitraryConfig: Arbitrary[Config] =
    Arbitrary {
      for {
        d1 <- choose(DIVISOR_MIN, DIVISOR_MAX)
        d2 <- choose(DIVISOR_MIN, DIVISOR_MAX)
        w1 <- arbitrary[String]
        w2 <- arbitrary[String]
      } yield Config(Seq(d1 -> w1, d2 -> w2))
    }

  def `Arbitrary pair of divisors: divisible by first` =
    arbitraryConfig { config: Config =>
      val runner = FizzBuzz.compile(config)
      // TODO: non-exhaustive
      val Config(Seq((d1, w1), (d2, _))) = config
      prop { i: Int =>
        (i % d1 == 0 && i % d2 != 0) ==>
        { runner(i) ==== w1 }
      }
    }.set(maxDiscardRatio = 300)
}
