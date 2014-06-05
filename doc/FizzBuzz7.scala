  val compile: Compiler = { case Config(pairs) =>
    val rules: Seq[Rule] = pairs map buildRule

    { i =>
      val wordOptions: Seq[Option[String]] =
        rules.map { rule => rule(i) }
      val combinedOption: Option[String] =
        wordOptions.reduce(addOption)
      combinedOption.getOrElse(i.toString)
    }
  }
