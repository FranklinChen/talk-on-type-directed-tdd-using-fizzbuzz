val optionAdd:
  (Option[String], Option[String]) => Option[String] = {
  (a1, a2) => (a1, a2) match {
    case (Some(s1), Some(s2)) => Some(s1 ++ s2)
    case (Some(s1), None)     => a1
    case (None,     Some(s2)) => a2
    case (None,     None)     => None
  }
}
