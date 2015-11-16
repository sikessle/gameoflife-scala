package org.sikessle.gameoflife.controller.impl

import com.google.inject.Inject
import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model
import org.sikessle.gameoflife.model.{Figure, _}

class GridControllerImpl extends Controller {

  var grid = createGrid(10, 20)
  var steppedGenerations = 0
  var gameRunning = true

  override def setGridSize(rows: Int, columns: Int): Unit = {
    grid = copyGridAsConstructible(grid, rows, columns).build
    setChangedAndNotify()
  }

  override def stepOneGeneration(): Unit = {
    grid = model.stepOneGeneration(grid, getStepper.step)
    steppedGenerations += 1
    setChangedAndNotify()
  }

  override def setCellToLivingAtPosition(row: Int, column: Int): Unit = {
    grid = changeCell(grid, row, column, value = true)
    setChangedAndNotify()
  }

  override def setCellToDeadAtPosition(row: Int, column: Int): Unit = {
    grid = changeCell(grid, row, column, value = false)
    setChangedAndNotify()
  }

  override def killAllCells(): Unit = {
    grid = model killAllCells grid
    setChangedAndNotify()
  }

  override def spawnFigure(figure: Figure, row: Int, column: Int): Unit = {
    grid = model.spawnFigure(grid, figure.coordinates, row, column)
    setChangedAndNotify()
  }

  override def stepperName: String = getStepper.name

  private def setChangedAndNotify(): Unit = {
    setChanged()
    notifyObservers()
  }

  override def quitGame(): Unit = gameRunning = false
}
