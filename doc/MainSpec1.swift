class MainSpec: XCTestCase {
  func test1to16() {
    let expected: String[] = [
      "1", "2", "Fizz", "4", "Buzz", "Fizz",
      "7", "8", "Fizz", "Buzz", "11", "Fizz",
      "13", "14", "FizzBuzz", "16"
    ]

    XCTAssert(Main.runToSeq(1, 16) == expected)
  }
}
