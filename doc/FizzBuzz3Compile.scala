  val compile: Compiler = {
    case Config((d1, w1), (d2, w2)) =>
      // Precompute, hence "compiler".
      val w = w1 + w2
      // Return an Evaluator.
      { i =>
        (i % d1 == 0, i % d2 == 0) match {
          case (true,  false) => w1
          case (false, true)  => w2
          case (true,  true)  => w
          case (false, false) => i.toString
        }
      }
  }
