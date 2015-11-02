package org.sikessle.gameoflife.view.gui

import org.sikessle.gameoflife.controller.Controller
import scala.swing.{BorderPanel, Frame}

class SwingView(val controller: Controller) extends Frame {

  private val gridPanel = new GridDrawingPanel(controller)
  private val controlPanel = new ControlPanel(controller)
  private val statusPanel = new StatusPanel(controller)

  menuBar = new MyMenuBar(controller, gridPanel)
  resizable = false
  visible = true

  contents = new BorderPanel() {
    add(gridPanel, BorderPanel.Position.North)
    add(controlPanel, BorderPanel.Position.Center)
    add(statusPanel, BorderPanel.Position.South)
  }
}
