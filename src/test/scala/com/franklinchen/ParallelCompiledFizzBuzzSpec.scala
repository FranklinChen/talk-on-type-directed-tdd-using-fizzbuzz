package com.franklinchen

import FizzBuzz._

class ParallelCompiledFizzBuzzSpec extends CompiledFizzBuzzSpec {
  override val compile = FizzBuzz.parallelCompile
}
