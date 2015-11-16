package org.sikessle.gameoflife

import com.google.inject.Guice
import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.view.gui.SwingView
import org.sikessle.gameoflife.view.text.TextView


object GameOfLife {

  def main(args: Array[String]) {
    val injector = Guice.createInjector(new BaseModule)
    import net.codingwell.scalaguice.InjectorExtensions._
    val controller = injector.instance[Controller]
    val textView = new TextView(controller)
    val swingView = new SwingView(controller)
    textView.readAndInterpretInLoopFromInputStream()
  }

}
