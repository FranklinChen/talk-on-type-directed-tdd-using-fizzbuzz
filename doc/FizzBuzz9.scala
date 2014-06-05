  val parallelCompile: Compiler = { case Config(pairs) =>
    val rules = pairs.toArray
      toArray.
      toPar.
      map(buildRule)

    { i: Int => rules.
      map { rule => rule(i) }.
      reduce(addOption).
      getOrElse(i.toString)
    }
  }
