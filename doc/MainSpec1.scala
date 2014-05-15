class MainSpec extends Specification { def is = s2"""
  ${Main.runToString(1, 16) ==== `expected for 1 to 16`}
  """
}
