  type Evaluator = Int => String
  case class Config(pair1: (Int, String),
                    pair2: (Int, String))
  type Compiler = Config => Evaluator

  val compile: Compiler = {
    case Config((d1, w1), (d2, w2)) =>
      {  i =>
        ???
      }
  }
