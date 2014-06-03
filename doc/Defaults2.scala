  val fizzBuzzPopperConfig: Config =
    Config(Seq(
      3 -> "Fizz", 5 -> "Buzz", 7 -> "Pop"
    ))

  val fizzBuzzPopper: Evaluator =
    FizzBuzz.compile(fizzBuzzPopperConfig)
