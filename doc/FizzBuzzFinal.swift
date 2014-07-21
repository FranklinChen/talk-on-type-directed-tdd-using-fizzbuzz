typealias Evaluator = Int -> String
typealias Config = [(Int, String)]
typealias Compiler = Config -> Evaluator
typealias Rule = Int -> String?
    
let buildRule: ((Int, String)) -> Rule = { n, word in
  { i in return (i % n == 0) ? word : nil } }
}

let compile: Compiler = { pairs in
  let rules: [Rule] = pairs.map(buildRule)
  return { i in
    let wordOptions = rules.map { rule in rule(i) }
    let combinedOption = wordOptions.reduce(nil, addOption)
    if let combined = combinedOption { return combined }
                                else { return String(i) }
  }
}
