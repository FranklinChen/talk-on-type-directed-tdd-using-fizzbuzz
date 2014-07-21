func runToSeq(i: Int, j: Int) -> [String] {
  return Array(i...j).map(Defaults.fizzBuzzer)
}
