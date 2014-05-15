  def runToStream(start: Int, end: Int,
    stream: PrintStream): Unit = {
    (start to end).
      map(Defaults.fizzBuzzer).
      foreach(stream.println)
  }
