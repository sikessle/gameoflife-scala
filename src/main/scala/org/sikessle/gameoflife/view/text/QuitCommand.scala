package org.sikessle.gameoflife.view.text

class QuitCommand extends Command {

  private val Key = "q"
  private val Description = "quit game"

  override def toString: String = Key + ": " + Description

  override protected def isResponsible(command: String, arguments: Args): Boolean = {
    command.equals(Key) && arguments.size == 0
  }

  override protected def execute(textView: TextView, arguments: Args): Unit = {
    textView.quit()
  }
}
