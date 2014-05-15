class FizzBuzzSpec extends Specification
    with ScalaCheck { def is = s2"""
  ${`Multiple of both 3 and 5 => "FizzBuzz"`}
  ${`Multiple of only 3 => "Fizz"`}
  ${`Multiple of only 5 => "Buzz"`}
  ${`Not a multiple of either 3 or 5 => number`}
  """

  def `Multiple of both 3 and 5 => "FizzBuzz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 == 0) ==>
      { FizzBuzz.output(i) ==== "FizzBuzz" }
    }
