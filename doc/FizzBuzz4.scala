  type Rule = Int => String

  val buildRule: ((Int, String)) => Rule = {
    case (n, word) => { i =>
      if (i % n == 0)
        word
      else
        ""
    }
  }
