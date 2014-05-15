package com.franklinchen

import scala.collection.immutable.SortedMap

/** Implementations of FizzBuzz algorithm. */
object FizzBuzz {
  type Outputter = Int => String

  type WordMap = SortedMap[Int, String]
  type Compiler = WordMap => Outputter

  type Rule = Int => Option[String]
  type Rules = Seq[Rule]
  type RuleBuilder = ((Int, String)) => Rule

  val buildRule: RuleBuilder = { case (n, word) =>
    i => if (i % n == 0) Some(word) else None
  }

  val optionAdd:
      (Option[String], Option[String]) => Option[String] = {
    (a1, a2) => (a1, a2) match {
      case (Some(s1), Some(s2)) => Some(s1 ++ s2)
      case (Some(s1), None)     => a1
      case (None,     Some(s2)) => a2
      case (None,     None)     => None
    }
  }

  val compile: Compiler = { wordMap =>
    val numbers: Iterable[Int] = wordMap.keys
    val pairs: Seq[(Int, String)] = wordMap.toSeq
    val rules: Rules = pairs.map(buildRule)

    i =>
    // map-reduce over options
    val words: Seq[Option[String]] = rules.map { rule => rule(i) }
    val combined: Option[String] = words.reduce(optionAdd)
    combined getOrElse i.toString
  }
}
