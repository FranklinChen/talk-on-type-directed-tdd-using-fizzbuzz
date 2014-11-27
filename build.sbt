name := "talk-on-type-directed-tdd-using-fizzbuzz"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz"))

startYear := Some(2014)

description := "Exploring type-directed TDD with FizzBuzz"

version := "1.0.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.github.scala-blitz" %% "scala-blitz" % "1.2",
  "org.scalaz.stream" %% "scalaz-stream" % "0.5a",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "org.scalacheck" %% "scalacheck" % "1.12.0" % "test",
  "org.specs2" %% "specs2" % "2.4.13" % "test",
  "org.typelevel" %% "shapeless-scalacheck" % "0.3" % "test"
)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
