## Talk: "Exploring type-directed test-driven development: a case study using FizzBuzz"

[![Build Status](https://travis-ci.org/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz.png)](https://travis-ci.org/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz)

Presentation for [Pittsburgh TechFest](http://pghtechfest.com/) 2014, Saturday June 7, 2014.

This repository contains Scala code. The Swift code is [here](https://github.com/franklinchen/fizzbuzz-swift).

### Abstract

(Note: this presentation will use live human volunteers to play the roles of various programming concepts.)

An expressive static type system is one of the most joyful and powerful tools for prototyping, designing, and maintaining programs. In this performance-theatrical presentation, I will provide a taste of how to use types, in conjunction with tests, to drive iterative development of a particular program, the famous FizzBuzz problem. We will solve generalizations of this problem, changing and adding requirements, to illustrate the pleasures and benefits of "type thinking".

The Scala language will be used the vehicle for this demonstration, but the techniques apply immediately to any industrial-strength statically typed language, such as Haskell, OCaml, F#, Rust, Swift.

### Photos

[![Photo of Franklin](https://pbs.twimg.com/media/BpjViavIAAAK0du.jpg)](https://twitter.com/cwinters/status/475364551584522240)

<a href="http://twitpic.com/e5o777" title=" ah, the beauty of pattern matching #scala #PGHTechFest @fran... on Twitpic"><img src="http://twitpic.com/show/thumb/e5o777.jpg" width="150" height="150" alt=" ah, the beauty of pattern matching #scala #PGHTechFest @fran... on Twitpic"></a>

### Article and slides

I strongly recommend reading the [*article*](https://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz/blob/master/doc/article.pdf).

But if you want the slides for the actual *presentation*, the latest version of the slides is available [here](https://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz/blob/master/doc/presentation.pdf).

#### Important note

The presentation slides at Pittsburgh TechFest had some serious bugs in the demo instructions that I have fixed. If you really want to see the buggy slides, check out the [this Git tag](https://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz/tree/pittsburgh-techfest-actual-presentation-buggy).

### Code in Scala

The code goes a bit beyond what was covered in the presentation. There is additional refactoring and abstraction, and the use of *traits* to automatically test different implementations that have the same interface.

The presentation deliberately stayed focused on the *core* FizzBuzz problem rather than go into the  questions of modular organization in the large, which differ more depending on the language. For example, we would probably use signatures/structures/functors in OCaml, and type classes in Haskell.

#### Coding style

For didactic purposes, to focus on functional programming, I presented code using first-class functions rather than the more idiomatic and realistic use of *traits*, classes, and methods. In real life, of course, I would use the host language's idiomatic features for maximum clarity and flexibility.

### Old stuff

A rough practice version of the presentation was given at the [Pittsburgh Scala Meetup](http://www.meetup.com/Pittsburgh-Scala-Meetup) earlier, [on May 15, 2014](http://www.meetup.com/Pittsburgh-Scala-Meetup/events/174013492/). I don't recommend even looking at them, because much has been improved.

But the slides are [here](https://github.com/FranklinChen/talk-on-type-directed-tdd-using-fizzbuzz/blob/meetup/doc/presentation.pdf) in case you want to see what changed.
