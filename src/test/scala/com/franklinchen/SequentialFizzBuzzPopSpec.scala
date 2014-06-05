package com.franklinchen

class SequentialFizzBuzzPopSpec extends FizzBuzzPopSpec {
  override val evaluate =
    FizzBuzz.compile(Defaults.fizzBuzzPopperConfig)
}
