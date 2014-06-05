package com.franklinchen

import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

import FizzBuzz._

object ArbitraryConfig {
  /** Only generates a pair. */
  val arbitraryConfig: Arbitrary[Config] =  Arbitrary {
    for {
      d1 <- choose(DIVISOR_MIN, DIVISOR_MAX)
      d2 <- choose(DIVISOR_MIN, DIVISOR_MAX)
      w1 <- arbitrary[String]
      w2 <- arbitrary[String]
    } yield Config(Seq(d1 -> w1, d2 -> w2))
  }

  val genPair: Gen[(Int, String)] =
    for {
      d <- choose(DIVISOR_MIN, DIVISOR_MAX)
      w <- arbitrary[String]
    } yield (d -> w)

  def genTuple(n: Int): Gen[Config] =
    for {
      seq <- listOfN(n, genPair)
    } yield Config(seq)

  /**
    @todo use this instead of original arbitraryConfig
    specialized to pair.
    */
  val arbitraryPairConfig: Arbitrary[Config] = Arbitrary {
    genTuple(2)
  }

  val arbitraryTripleConfig: Arbitrary[Config] = Arbitrary {
    genTuple(3)
  }
}
