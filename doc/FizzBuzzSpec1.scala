class FizzBuzzSpec extends Specification { def is = s2"""
  ${FizzBuzz.output(15) ==== "FizzBuzz"}
  """
}
