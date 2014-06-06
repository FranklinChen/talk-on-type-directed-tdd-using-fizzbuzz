  def addOption(a1: Option[String], a2: Option[String]):
      Option[String] = (a1, a2) match {
    case (Some(s1), None)     => Some(s1)
    case (None,     Some(s2)) => Some(s2)
    case (Some(s1), Some(s2)) => Some(s1 + s2)
    case (None,     None)     => None
  }
