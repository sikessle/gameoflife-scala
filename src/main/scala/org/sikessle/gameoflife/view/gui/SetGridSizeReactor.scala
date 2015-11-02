package org.sikessle.gameoflife.view.gui

import org.sikessle.gameoflife.controller.Controller

import scala.swing._
import scala.swing.event.ActionEvent

class SetGridSizeReactor(val rowsField: TextField, val columnsField: TextField,
                         val controller: Controller) extends Reactor {


  reactions += {
    case _:ActionEvent =>
      val rows = getCheckedNumberOfField(rowsField)
      val columns = getCheckedNumberOfField(columnsField)
      controller.setGridSize(rows, columns)
  }

  private def getCheckedNumberOfField(field: TextField): Int = {
    try {
      field.text.toInt
    } catch {
      case e: Exception => 1
    }
  }

}
