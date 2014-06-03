class FizzBuzzSpec extends Specification
    with ScalaCheck { def is = s2"""
  ${`Multiple of both 3 and 5 => "FizzBuzz"`}
  """
  def `Multiple of both 3 and 5 => "FizzBuzz"` =
    prop { i: Int => (i % 3 == 0 && i % 5 == 0) ==>
      { FizzBuzz.evaluate(i) ==== "FizzBuzz" }
    }
}
