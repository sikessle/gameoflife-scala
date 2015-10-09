package org.sikessle.gameoflife.view.text

class StepNGenerationsCommand extends Command {

  private val Key = "n"
  private val Description = "[x]: step x generations"
  private val DelayBetweenFramesMs = 100
  private var frames = 1

  override def toString: String = Key + ": " + Description

  private def validArgs(arguments: Args): Boolean = {
    if (arguments.size != 1) return false

    try {
      frames = arguments.iterator.next().toInt
      frames > 0
    } catch {
      case e: Exception => false
    }
  }

  override protected def isResponsible(command: String, arguments: Args): Boolean = {
    command.equals(Key) && validArgs(arguments)
  }

  override protected def execute(textView: TextView, arguments: Args): Unit = {
    for (i <- 0 until frames) {
      textView.controller.stepOneGeneration()
      sleepBetweenGenerations()
    }

  }

  private def sleepBetweenGenerations(): Unit = {
    try {
      Thread.sleep(DelayBetweenFramesMs)
    } catch {
      case e: InterruptedException => Thread.currentThread().interrupt()
    }
  }
}
