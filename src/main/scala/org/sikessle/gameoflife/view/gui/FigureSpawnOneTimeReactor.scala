package org.sikessle.gameoflife.view.gui

import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model.Figure

import scala.swing.Reactor
import scala.swing.event.MouseClicked


class FigureSpawnOneTimeReactor(val controller: Controller, val gridPanel: GridDrawingPanel,
                                val figure: Figure) extends Reactor {

  listenTo(gridPanel)

  reactions += {
    case e: MouseClicked =>
      val row = e.point.y / gridPanel.CellSize
      val column = e.point.x / gridPanel.CellSize
      controller.setCellToDeadAtPosition(row, column)
      controller.spawnFigure(figure, row, column)
      deafTo(gridPanel)
  }

}
