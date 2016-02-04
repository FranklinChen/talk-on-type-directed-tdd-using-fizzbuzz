name := "talk-on-type-directed-tdd-using-fizzbuzz"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz"))

startYear := Some(2014)

description := "Exploring type-directed TDD with FizzBuzz"

version := "1.0.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.github.scala-blitz" %% "scala-blitz" % "1.2",
  "org.scalaz" %% "scalaz-core" % "7.2.0",
  "org.specs2" %% "specs2-core" % "3.7" % Test,
  "org.specs2" %% "specs2-scalacheck" % "3.7" % Test,
  "org.typelevel" %% "shapeless-scalacheck" % "0.4" % Test
)
