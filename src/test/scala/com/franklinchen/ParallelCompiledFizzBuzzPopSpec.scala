package com.franklinchen

import FizzBuzz._

class ParallelCompiledFizzBuzzPopSpec extends CompiledFizzBuzzPopSpec {
  override def compile: Compiler = FizzBuzz.parallelCompile
}
