  val compile: Compiler = {
    case Config(Seq((d1, w1), (d2, w2))) =>
      val w = w1 + w2

      { i =>
        (i % d1 == 0, i % d2 == 0) match {
          case (true,  false) => w1
          case (false, true)  => w2
          case (true,  true)  => w
          case (false, false) => i.toString
        }
      }
    case _ => // TODO handle more than 2
      { i => ??? }
  }
