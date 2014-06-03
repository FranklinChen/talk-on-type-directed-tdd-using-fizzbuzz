  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => { i =>
      if (i % n == 0) Some(word) else None
    }
  }

  val compile: Compiler = { case Config(pairs) =>
    val rules: Seq[Rule] = pairs map buildRule

    { i =>
      val words: Seq[Option[String]] =
        rules map { rule => rule(i) }
      val combinedWords: Option[String] =
        words reduce addOption
      combinedWords getOrElse i.toString
    }
  }
