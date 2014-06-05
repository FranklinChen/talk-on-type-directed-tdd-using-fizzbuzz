package com.franklinchen

import FizzBuzz._

object Defaults {
  // Buggy and ugly!
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

  // Useful to keep old implementation
  val oldFizzBuzzer: Evaluator = { i =>
    (i % 3 == 0, i % 5 == 0) match {
      case (true,  false) => "Fizz"
      case (false, true)  => "Buzz"
      case (true,  true)  => "FizzBuzz"
      case (false, false) => i.toString
    }
  }

  val fizzBuzzerConfig: Config =
    Config(Seq(
      3 -> "Fizz", 5 -> "Buzz"
    ))

  val fizzBuzzer: Evaluator =
    FizzBuzz.compile(Defaults.fizzBuzzerConfig)

  val fizzBuzzPopperConfig: Config =
    Config(Seq(
      3 -> "Fizz", 5 -> "Buzz", 7 -> "Pop"
    ))
}
