package org.sikessle.gameoflife.view.text

class StepOneGenerationCommand extends Command {

  private val Key = "n"
  private val Description = "step 1 generation"

  override def toString: String = Key + ": " + Description

  override protected def isResponsible(command: String, arguments: Args): Boolean = {
    command.equals(Key) && arguments.size == 0
  }

  override protected def execute(textView: TextView, arguments: Args): Unit = {
    textView.controller.stepOneGeneration()
  }
}
