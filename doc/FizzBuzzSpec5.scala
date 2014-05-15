  def is = s2"""
  ...
  ${Defaults.fizzBuzzPopper(2) ==== "2"}
  ${Defaults.fizzBuzzPopper(21) ==== "FizzPop"}
  ${Defaults.fizzBuzzPopper(9) ==== "Fizz"}
  ${Defaults.fizzBuzzPopper(7) ==== "Pop"}
  ${Defaults.fizzBuzzPopper(35) ==== "BuzzPop"}
  """
