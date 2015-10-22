package org.sikessle.gameoflife.view.text

case class Args(inputToParse: String) extends Iterable[String] {

  val cmd: String = if (inputToParse.trim().isEmpty) "" else inputToParse.trim().split(" ")(0)

  val args: Array[String] = if (inputToParse.trim().isEmpty) Array[String]()
  else for (a <- inputToParse.trim().split(" ").drop(1)) yield a

  override def iterator = args.iterator

  override def size: Int = args.length
}
