  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => { i =>
      if (i % n == 0) Some(word) else None
    }
  }

  val compile: Compiler = { case Config(pairs) =>
    val rules: Seq[Rule] = pairs map buildRule

    { i =>
      val wordOptions: Seq[Option[String]] =
        rules map { rule => rule(i) }
      val combinedOption: Option[String] =
        wordOptions reduce addOption
      combinedOption getOrElse i.toString
    }
  }
