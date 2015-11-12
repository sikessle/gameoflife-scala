package org.sikessle.gameoflife

import org.sikessle.gameoflife.controller.impl.GridControllerImpl
import org.sikessle.gameoflife.model._
import org.sikessle.gameoflife.view.gui.SwingView
import org.sikessle.gameoflife.view.text.TextView


object GameOfLife {

  def main(args: Array[String]) {
    val grid = createGrid(10, 20)
    // TODO use DI
    val controller = new GridControllerImpl(grid)
    val textView = new TextView(controller)
    val swingView = new SwingView(controller)
    textView.readAndInterpretInLoopFromInputStream()
  }

}
