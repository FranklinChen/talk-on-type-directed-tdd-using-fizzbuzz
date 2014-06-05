  type Rule = Int => Option[String]

  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => { i =>
      (i % n == 0).option(word)
    }
  }
