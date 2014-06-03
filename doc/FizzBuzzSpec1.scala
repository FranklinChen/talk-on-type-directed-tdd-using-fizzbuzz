class FizzBuzzSpec extends Specification { def is = s2"""
  ${FizzBuzz.evaluate(15) ==== "FizzBuzz"}
  ${FizzBuzz.evaluate(20) ==== "Buzz"}
  ${FizzBuzz.evaluate(6) ==== "Fizz"}
  ${FizzBuzz.evaluate(17) ==== "17"}
  """
}
