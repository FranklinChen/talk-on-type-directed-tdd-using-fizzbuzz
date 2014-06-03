  type Evaluator = Int => String
  case class Config(pair1: (Int, String),
                    pair2: (Int, String))
  type Compiler = Config => Evaluator

  val compile: Compiler = {
    case Config((divisor1, word1), (divisor2, word2)) =>
      {  i =>
        ???
      }
  }
