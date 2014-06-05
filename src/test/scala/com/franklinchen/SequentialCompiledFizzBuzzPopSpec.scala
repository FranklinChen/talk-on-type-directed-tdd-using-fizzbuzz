package com.franklinchen

import FizzBuzz._

class SequentialCompiledFizzBuzzPopSpec extends CompiledFizzBuzzPopSpec {
  override def compile: Compiler = FizzBuzz.compile
}
