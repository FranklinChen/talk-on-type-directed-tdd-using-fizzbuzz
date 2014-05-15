type Rule = Int => String
type Rules = Seq[Rule]
type RuleBuilder = ((Int, String)) => Rule

val buildRule: RuleBuilder = { case (n, word) =>
  i => ???
}
