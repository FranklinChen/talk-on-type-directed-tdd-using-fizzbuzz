package com.franklinchen

import org.specs2._

class MainSpec extends Specification { def is = s2"""
  ${Main.runToString(1, 16) ==== `expected for 1 to 16`}
  """

  /** Handwritten example. */
  val `expected for 1 to 16` = """1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
"""
}
