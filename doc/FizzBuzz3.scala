type WordMap = OrderedMap[Int, String]
type Compiler = WordMap => Outputter

val compile: Compiler = { wordMap =>
  i => ???
}
