val buildRule: RuleBuilder = { case (n, word) =>
  i => if (i % n == 0) word else ""
}

val compile: Compiler = { wordMap =>
  val numbers: Iterable[Int] = wordMap.keys
  val pairs: Seq[(Int, String)] = wordMap.toSeq
  val rules: Rules = pairs.map(buildRule)

  i =>
  val words: Seq[String] = rules.map { rule => rule(i) }
  val combined: String = words.mkString
  if (combined.isEmpty) i.toString else combined
}
