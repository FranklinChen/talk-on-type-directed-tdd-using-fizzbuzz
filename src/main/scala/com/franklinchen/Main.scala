package com.franklinchen

object Main extends App {
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
  runToSeq(1, 100) foreach println

  def runToSeq(start: Int, end: Int): Seq[String] = {
    (start to end) map Defaults.fizzBuzzer
  }
}
