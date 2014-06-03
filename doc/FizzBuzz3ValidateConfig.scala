  case class Config(pair1: (Int, String),
                    pair2: (Int, String)) {
    validatePair(pair1); validatePair(pair2)
  }
