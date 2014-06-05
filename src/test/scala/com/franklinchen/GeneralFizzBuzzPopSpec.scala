package com.franklinchen

import org.specs2._
import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import org.scalacheck.Prop._

import FizzBuzz._

/** @todo */
trait GeneralFizzBuzzPopSpec extends Specification
    with ScalaCheck { def is = s2"""
  """

  def evaluate: FizzBuzz.Evaluator
}
