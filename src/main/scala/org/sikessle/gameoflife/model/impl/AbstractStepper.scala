package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.{Grid, Stepper}

abstract class AbstractStepper extends Stepper {

  override def step(grid: Grid): Grid = {
    val newGrid = GridBuilder.start(grid)

    for (i <- 0 until grid.rows) {
      for (j <- 0 until grid.columns) {
        newGrid(i)(j) = nextStateOfCell(grid, i, j)
      }
    }
    newGrid.build()
  }

  private def nextStateOfCell(grid: Grid, cellRow: Int, cellColumn: Int): Boolean = {
    val livingNeighbors = countLivingNeighbors(grid, cellRow, cellColumn)

    if (grid(cellRow)(cellColumn)) {
      nextStateOfLivingCell(livingNeighbors)
    } else {
      nextStateOfDeadCell(livingNeighbors)
    }
  }

  def countLivingNeighbors(grid: Grid, cellRow: Int, cellColumn: Int): Int = {
    var livingNeighbors = 0

    for (i <- cellRow - 1 until cellRow + 1; if isRowIndexInBound(i, grid)) {
      livingNeighbors += countLivingNeighborsInRow(grid, i, cellRow, cellColumn)
    }

    livingNeighbors
  }

  def countLivingNeighborsInRow(grid: Grid, currentRow: Int, cellRow: Int, cellColumn: Int) = {
    var livingNeighborsInRow = 0

    for (j <- cellColumn - 1 until cellColumn + 1;
         if isColumnIndexInBound(j, grid) && (currentRow != cellRow || j != cellColumn)
           && grid(currentRow)(j)) {
      livingNeighborsInRow += 1
    }

    livingNeighborsInRow
  }

  private def isRowIndexInBound(i: Int, grid: Grid): Boolean = i >= 0 && i < grid.rows

  private def isColumnIndexInBound(j: Int, grid: Grid): Boolean = j >= 0 && j < grid.columns

  def nextStateOfLivingCell(livingNeighbors: Int): Boolean

  def nextStateOfDeadCell(livingNeighbors: Int): Boolean

}
