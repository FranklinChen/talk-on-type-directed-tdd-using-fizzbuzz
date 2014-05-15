package com.franklinchen

import java.io.PrintStream
import java.io.ByteArrayOutputStream

object Main {
  /**
    http://c2.com/cgi/wiki?FizzBuzzTest

    Write a program that
      prints the numbers from 1 to 100.
    But for multiples of three,
      print "Fizz" instead of the number.
    And for the multiples of five,
      print "Buzz".
    For numbers which are multiples of both three and five,
      print "FizzBuzz".
    */
  def main(args: Array[String]): Unit = {
    runToStream(1, 100, Console.out)
  }

  def runToStream(start: Int, end: Int,
    stream: PrintStream): Unit = {
    (start to end).
      map(Defaults.fizzBuzzer).
      foreach(stream.println)
  }

  def runToString(start: Int, end: Int): String = {
    val outputStream = new ByteArrayOutputStream
    val stream = new PrintStream(outputStream)
    runToStream(start, end, stream)
    outputStream.toString
  }
}
