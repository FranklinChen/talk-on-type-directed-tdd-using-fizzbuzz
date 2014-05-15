val buildRule: RuleBuilder = { case (n, word) =>
  i => if (i % n == 0) Some(word) else None
}

val compile: Compiler = { wordMap =>
  val numbers: Iterable[Int] = wordMap.keys
  val pairs: Seq[(Int, String)] = wordMap.toSeq
  val rules: Rules = pairs.map(buildRule)

  i =>
  val words: Seq[Option[String]] =
    rules.map { rule => rule(i) }
  val combined: Option[String] = words.reduce(optionAdd)
  combined getOrElse i.toString
}
