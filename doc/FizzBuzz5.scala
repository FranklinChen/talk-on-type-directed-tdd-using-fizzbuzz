  type Evaluator = Int => String
  type Compiler = Config => Evaluator
  type Rule = Int => String
  val compile: Compiler = { case Config(pairs) =>
    val rules: Seq[Rule] = pairs map buildRule // compile
    // Return an Evaluator.
    { i =>
      val words: Seq[String] = rules map { rule => rule(i) }
      val combined: String = words reduce { (x, y) => x+y }
      if (combined.isEmpty)
        i.toString
      else
        combined
    }
  }
