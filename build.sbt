name := "talk-on-type-directed-tdd-with-fizzbuzz"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/talk-on-type-directed-tdd-with-fizzbuzz"))

startYear := Some(2014)

description := "Exploring type-directed TDD with FizzBuzz"

version := "1.0.0"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  "org.scalaz.stream" %% "scalaz-stream" % "0.4.1",
  "org.scalaz" %% "scalaz-core" % "7.0.6",
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

incOptions := incOptions.value.withNameHashing(true)
