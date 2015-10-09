package org.sikessle.gameoflife

import org.sikessle.gameoflife.model.impl.{GridBuilder, OriginalStepper}

package object model {

  def createGrid(rows: Int, columns: Int): Grid = GridBuilder.start(rows, columns).build()

  def copyGridAsConstructible(grid: Grid): GridBuilder.Constructible = GridBuilder.copy(grid)

  def copyGridAsConstructible(grid: Grid, newRows: Int, newColumns: Int): GridBuilder.Constructible = {
    GridBuilder.copy(grid, newRows, newColumns)
  }

  def getStepper: Stepper = OriginalStepper

  def stepOneGeneration(grid: Grid, stepper: Grid => Grid): Grid = {
    stepper(grid)
  }

  def changeCell(grid: Grid, row: Int, column: Int, value: Boolean): Grid = {
    val changedGrid = copyGridAsConstructible(grid)
    changedGrid(row)(column) = value
    changedGrid.build()
  }

  def killAllCells(grid: Grid): Grid = GridBuilder.start(grid).build()

  def spawnFigure(grid: Grid, figureCoords: List[(Int, Int)], row: Int, column: Int): Grid = {
    val newGrid = copyGridAsConstructible(grid)
    // coordinates
    for (coord <- figureCoords) (i: Int, j: Int) => newGrid(row + i)(column + j) = true
    newGrid.build()
  }

}