func addOption(a1: String?, a2: String?) -> String? = {
  switch (a1, a2) {
  case (let .Some(s1), .None):         return .Some(s1)
  case (.None, let .Some(s2)):         return .Some(s2)
  case (let .Some(s1), let .Some(s2)): return .Some(s1+s2)
  case (.None, .None):                 return .None
  }
}
