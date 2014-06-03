  val arbitraryConfig: Arbitrary[Config] =
    Arbitrary {
      for {
        d1 <- choose(DIVISOR_MIN, DIVISOR_MAX) 
        d2 <- choose(DIVISOR_MIN, DIVISOR_MAX)
        w1 <- arbitrary[String]
        w2 <- arbitrary[String]
      } yield Config(d1 -> w1, d2 -> w2)
    }
