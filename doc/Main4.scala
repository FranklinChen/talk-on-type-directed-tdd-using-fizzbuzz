  def runToSeq(start: Int, end: Int): Seq[String] = {
    start.to(end).map(FizzBuzz.evaluate)
  }
