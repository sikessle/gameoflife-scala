package org.sikessle.gameoflife.view.text

class Args(inputToParse: String) extends Iterable[String] {

  private var args: Array[String] = _

  parseAndTrim(inputToParse)

  private def parseAndTrim(inputToParse: String): Unit = {
    val rawArgs = inputToParse.trim().split(" ")
    if (rawArgs(0).isEmpty) {
      args = new Array[String](0)
      return
    }
    args = new Array[String](rawArgs.length)

    for (i <- 0 until rawArgs.length) {
      args(i) = rawArgs(i).trim
    }
  }

  override def iterator = args.iterator

  override def size: Int = args.length
}
