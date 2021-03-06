  def `Multiple of only 3 => "Fizz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 != 0) ==>
      { FizzBuzz.evaluate(i) ==== "Fizz" }
    }

  def `Multiple of only 5 => "Buzz"` =
    prop { i: Int => (i % 3 != 0 && i % 5 == 0) ==>
      { FizzBuzz.evaluate(i) ==== "Buzz" }
    }

  def `Not a multiple of either 3 or 5 => number` =
    prop { i: Int => (i % 3 != 0 && i % 5 != 0) ==>
      { FizzBuzz.evaluate(i) ==== i.toString }
    }
