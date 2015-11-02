package org.sikessle.gameoflife.view.gui

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model.Figure



class FigureSpawnOneTimeReactor(val controller: Controller, val gridPanel: GridDrawingPanel,
                                val figure: Figure) extends MouseAdapter {

  gridPanel.peer.addMouseListener(this)

  override def mouseClicked(e: MouseEvent): Unit = {
    val row = e.getY / gridPanel.CellSize
    val column = e.getX / gridPanel.CellSize
    controller.spawnFigure(figure, row, column)
    gridPanel.peer.removeMouseListener(this)
  }

}
