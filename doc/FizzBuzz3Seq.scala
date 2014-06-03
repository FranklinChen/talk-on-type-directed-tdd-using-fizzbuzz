  case class Config(pairs: Seq[(Int, String)]) {
    pairs foreach validatePair
  }
