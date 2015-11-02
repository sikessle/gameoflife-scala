package org.sikessle.gameoflife.view.gui

import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model.impl.{RPentominoFigure, GliderFigure}

import scala.collection.mutable.ListBuffer
import scala.swing.MenuItem
import scala.swing.event.MouseClicked

class FigureMenuBuilder(val controller: Controller, val gridPanel: GridDrawingPanel) {

  val figures = GliderFigure :: RPentominoFigure :: Nil

  def buildFiguresMenu(): List[MenuItem] = {
    var result = new ListBuffer[MenuItem]

    for (figure <- figures) {
      val item = new MenuItem(figure.name)
      item.reactions += {
        case _:MouseClicked => new FigureSpawnOneTimeReactor(controller, gridPanel, figure)
      }
      result += item
    }

    result.toList
  }

}
