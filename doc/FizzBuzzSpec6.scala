  def `Arbitrary word fizzBuzzers on a multiple of 3` =
    prop { (fizz: String, buzz: String) =>
      val fizzBuzzer = FizzBuzz.compile(
        SortedMap(3 -> fizz, 5 -> buzz)
      )
      prop { i: Int => (i % 3 == 0 && i % 5 != 0) ==>
        { fizzBuzzer(i) ==== fizz }
      }
    }
