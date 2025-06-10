package tests.pc

import tests.BaseCompletionSuite

class CompletionCaseInsensitiveSuite extends BaseCompletionSuite {

  check(
    "use case insensitive comparison for first character of query",
    """
      |object A {
      | def test(longNameYouWillNotRemember: Long): Unit = {
      |   val foo = nam@@
      | }
      |}""".stripMargin,
    """longNameYouWillNotRemember: Long
      |deprecatedName scala
      |management java.lang
      |""".stripMargin
  )

  check(
    "use case insensitive comparison for first character of query, correctly narrow result using later uppercase in query",
    """
      |object A {
      | def test(longNameYouWillNotRemember: Long): Unit = {
      |   val foo = namY@@
      | }
      |}""".stripMargin,
    """longNameYouWillNotRemember: Long
      |""".stripMargin
  )


}
