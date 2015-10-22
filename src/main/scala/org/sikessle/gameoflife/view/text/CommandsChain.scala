package org.sikessle.gameoflife.view.text

import scala.collection.immutable
import scala.collection.mutable

class CommandsChain {

  val commands = immutable.Queue[Command](
    new QuitCommand,
    new ClearGridCommand,
    new SetGridSizeCommand,
    new StepOneGenerationCommand,
    new StepNGenerationsCommand,
    new ToggleCellCommand
  )

  def handle(textView: TextView, command: String, arguments: Args): Unit = {
    commands.map(cmd => cmd.handle(textView, command, arguments))
  }

  def getAllCommandDescriptions: List[String] = {
    val descriptions = new mutable.ListBuffer[String]
    for (cmd <- commands) {
      descriptions += cmd.toString
    }
    descriptions.toList
  }


}
