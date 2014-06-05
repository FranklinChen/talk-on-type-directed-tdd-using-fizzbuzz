package com.franklinchen

import FizzBuzz._

trait CompiledFizzBuzzSpec extends FizzBuzzSpec {
  def compile: Compiler

  override def evaluate = compile(Defaults.fizzBuzzerConfig)
}
