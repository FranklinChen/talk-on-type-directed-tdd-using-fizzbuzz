  val DIVISOR_MIN = 2
  val DIVISOR_MAX = 100

  def validatePair(pair: (Int, String)) = pair match {
    case (d, _) =>
      require(d >= DIVISOR_MIN,
        s"divisor $d must be >= $DIVISOR_MIN")
      require(d <= DIVISOR_MAX,
        s"divisor $d must be <= $DIVISOR_MAX")
  }

  case class Config(pair1: (Int, String),
                    pair2: (Int, String)) {
    validatePair(pair1); validatePair(pair2)
  }
