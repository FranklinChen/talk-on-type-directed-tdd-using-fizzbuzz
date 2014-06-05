package com.franklinchen

import FizzBuzz._

class SequentialCompiledFizzBuzzSpec extends CompiledFizzBuzzSpec {
  override val compile = FizzBuzz.compile
}
