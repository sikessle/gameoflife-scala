package org.sikessle.gameoflife.controller.impl

import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model
import org.sikessle.gameoflife.model.{Figure, _}

class GridControllerImpl extends Controller {

  val GridInitRows = 10
  val GridInitColumns = 20
  var grid = createGrid(GridInitRows, GridInitColumns)
  var steppedGenerations = 0

  override def setGridSize(rows: Int, columns: Int): Unit = {
    grid = copyGridAsConstructible(grid, rows, columns).build()
    setChangedAndNotify
  }

  override def stepNGenerations(n: Int): Unit = {
    for (i <- 0 until n) {
      grid = stepOneGeneration(grid, getStepper.step)
      steppedGenerations += 1
      setChangedAndNotify
    }
  }

  override def setCellToLivingAtPosition(row: Int, column: Int): Unit = {
    grid = changeCell(grid, row, column, value = true)
    setChangedAndNotify
  }

  override def setCellToDeadAtPosition(row: Int, column: Int): Unit = {
    grid = changeCell(grid, row, column, value = false)
    setChangedAndNotify
  }

  override def killAllCells: Unit = {
    grid = model.killAllCells(grid)
    setChangedAndNotify
  }

  override def spawnFigure(figure: Figure, row: Int, column: Int): Unit = {
    grid = model.spawnFigure(grid, figure.coordinates, row, column)
    setChangedAndNotify
  }

  override def stepperName: String = getStepper.name

  private def setChangedAndNotify(): Unit = {
    setChanged()
    notify()
  }
}
