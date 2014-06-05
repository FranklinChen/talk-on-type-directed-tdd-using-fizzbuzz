  def runToSeq(start: Int, end: Int): Seq[String] = {
    start.to(end).map(Defaults.fizzBuzzer)
  }
