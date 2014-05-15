object Defaults {
  val wordMap: FizzBuzz.WordMap =
    SortedMap(3 -> "Fizz", 5 -> "Buzz")

  val fizzBuzzer: FizzBuzz.Outputter =
    FizzBuzz.compile(wordMap)
  }

  val oldFizzBuzzer: FizzBuzz.Outputter = { i =>
    (i % 3 == 0, i % 5 == 0) match {
      case (true, true) => "FizzBuzz"
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case (false, false) => i.toString
    }
  }
}
