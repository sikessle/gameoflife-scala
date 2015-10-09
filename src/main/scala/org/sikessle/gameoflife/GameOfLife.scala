package org.sikessle.gameoflife

import org.sikessle.gameoflife.controller.impl.GridControllerImpl
import org.sikessle.gameoflife.view.text.TextView

class GameOfLife {

  def main (args: Array[String]){
    // add GUI here
    val controller = new GridControllerImpl()
    val textView = new TextView(controller)
    textView.readAndInterpretInLoopFromInputStream
  }

}
