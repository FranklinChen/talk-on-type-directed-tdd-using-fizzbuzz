  def is = s2"""
  ...
  ${fizzBuzzPopper(2) ==== "2"}
  ${fizzBuzzPopper(21) ==== "FizzPop"}
  ${fizzBuzzPopper(9) ==== "Fizz"}
  ${fizzBuzzPopper(7) ==== "Pop"}
  ${fizzBuzzPopper(45) ==== "BuzzPop"}
  """

  def fizzBuzzPopper = FizzBuzz.compile(
    SortedMap(3 -> "Fizz", 5 -> "Buzz", 7 -> "Pop")
  )
