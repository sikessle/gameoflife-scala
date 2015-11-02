package org.sikessle.gameoflife

import org.sikessle.gameoflife.controller.impl.GridControllerImpl
import org.sikessle.gameoflife.view.gui.SwingView
import org.sikessle.gameoflife.view.text.TextView


object GameOfLife {

  def main(args: Array[String]) {
    val controller = new GridControllerImpl()
    val textView = new TextView(controller)
    val swingView = new SwingView(controller)
    textView.readAndInterpretInLoopFromInputStream()
  }

}
