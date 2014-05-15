val fizzBuzzPopper: FizzBuzz.Outputter =
  FizzBuzz.compile(
    SortedMap(3 -> "Fizz", 5 -> "Buzz", 7 -> "Pop")
  )
