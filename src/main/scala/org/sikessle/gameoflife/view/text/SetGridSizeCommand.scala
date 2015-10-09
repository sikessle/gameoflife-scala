package org.sikessle.gameoflife.view.text

class SetGridSizeCommand extends Command {

  private val Key = "s"
  private val Description = "[x] [y]: set grid size"
  private var i = -1
  private var j = -1

  override def toString: String = Key + ": " + Description

  private def validArgs(arguments: Args): Boolean = {
    if (arguments.size != 2) return false
    val iterator = arguments.iterator
    try {
      i = iterator.next().toInt
      j = iterator.next().toInt
      i > 0 && j > 0
    } catch {
      case e: Exception => false
    }
  }

  override protected def isResponsible(command: String, arguments: Args): Boolean = {
    command.equals(Key) && validArgs(arguments)
  }

  override protected def execute(textView: TextView, arguments: Args): Unit = {
    textView.controller.setGridSize(i, j)
  }
}
