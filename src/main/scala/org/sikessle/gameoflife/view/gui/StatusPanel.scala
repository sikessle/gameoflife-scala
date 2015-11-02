package org.sikessle.gameoflife.view.gui

import java.util.{Observable, Observer}

import org.sikessle.gameoflife.controller.Controller

import scala.swing._

class StatusPanel(val controller: Controller) extends FlowPanel with Observer {

  private val status = new Label

  controller.addObserver(this)

  contents += status

  override def update(o: Observable, arg: scala.Any): Unit = {
    status.text = "Generation Strategy: " + controller.stepperName
  }
}
