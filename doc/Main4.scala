  def runToStream(start: Int, end: Int,
    stream: PrintStream): Unit = {
    (start to end).
      map(FizzBuzz.output).
      foreach(stream.println)
  }
