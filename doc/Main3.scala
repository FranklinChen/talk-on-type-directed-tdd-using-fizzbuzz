  def runToString(start: Int, end: Int): String = {
    val outputStream = new ByteArrayOutputStream
    val stream = new PrintStream(outputStream)
    runToStream(start, end, stream)
    outputStream.toString
  }
