package org.sikessle.gameoflife.view.gui

import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model.impl.{GliderFigure, RPentominoFigure}

import scala.collection.mutable.ListBuffer
import scala.swing.MenuItem
import scala.swing.event.ActionEvent

class FigureMenuBuilder(val controller: Controller, val gridPanel: GridDrawingPanel) {

  val figures = GliderFigure :: RPentominoFigure :: Nil

  def buildFiguresMenu(): List[MenuItem] = {
    var result = new ListBuffer[MenuItem]

    for (figure <- figures) {
      val item = new MenuItem(figure.name)
      item.reactions += {
        case _:ActionEvent =>
          new FigureSpawnOneTimeReactor(controller, gridPanel, figure)
      }
      item.listenTo(item)
      result += item
    }

    result.toList
  }

}
