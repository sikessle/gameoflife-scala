package org.sikessle.gameoflife.view.text

abstract class Command {

  def handle(textView: TextView, command: String, arguments: Args): Unit = {
    if (isResponsible(command, arguments)) execute(textView, arguments)
  }

  protected def isResponsible(command: String, arguments: Args): Boolean

  protected def execute(textView: TextView, arguments: Args): Unit
}
