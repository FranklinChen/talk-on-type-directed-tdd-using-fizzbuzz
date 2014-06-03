  type Evaluator = Int => String
  type Compiler = Config => Evaluator
  type Rule = Int => String
  val compile: Compiler = { case Config(pairs) =>
    // Precompute, hence "compiler".
    val rules: Seq[Rule] = pairs map buildRule
    // Return an Evaluator.
    { i =>
      val words: Seq[String] = rules map { rule => rule(i) }
      val combinedWords: String = words.mkString
      if (combinedWords.isEmpty)
        i.toString
      else
        combinedWords
    }
  }
