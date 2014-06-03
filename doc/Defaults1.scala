object Defaults {
  val fizzBuzzerConfig: Config =
    Config(3 -> "Fizz", 5 -> "Buzz")

  val fizzBuzzer: Evaluator =
    FizzBuzz.compile(fizzBuzzerConfig)

  // Useful to keep old implementation
  val oldFizzBuzzer: Evaluator = { i =>
    (i % 3 == 0, i % 5 == 0) match {
      case (true,  false) => "Fizz"
      case (false, true)  => "Buzz"
      case (true,  true)  => "FizzBuzz"
      case (false, false) => i.toString
    }
  }
}
