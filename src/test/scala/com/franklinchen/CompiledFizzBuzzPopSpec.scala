package com.franklinchen

import FizzBuzz._

trait CompiledFizzBuzzPopSpec extends FizzBuzzPopSpec {
  def compile: Compiler

  override def evaluate = compile(Defaults.fizzBuzzPopperConfig)
}
