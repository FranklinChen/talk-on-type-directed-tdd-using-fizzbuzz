  val arbitraryConfig: Arbitrary[Config] = Arbitrary {
    for {
      (d1, d2, w1, w2) <-
        arbitrary[(Int, Int, String, String)]
    } yield Config(d1 -> w1, d2 -> w2)
  }

  def `Arbitrary pair of divisors: divisible by first` =
    arbitraryConfig { config: Config =>
      val evaluate = FizzBuzz.compile(config)
      val Config((d1, w1), (d2, _)) = config
      prop { i: Int => (i % d1 == 0 && i % d2 != 0) ==>
        { evaluate(i) ==== w1 }
      }
    }
