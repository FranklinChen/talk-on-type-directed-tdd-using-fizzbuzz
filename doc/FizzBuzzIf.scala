  // Buggy and ugly!
  val evaluate: Evaluator = { i =>
    if (i % 3 == 0)
      "Fizz"
    else if (i % 5 == 0)
      "Buzz"
    else if (i % 3 == 0 && i % 5 == 0)
      "FizzBuzz"
    else
      i.toString
  }
