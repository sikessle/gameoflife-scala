package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Grid

class GridImpl (cellsState: BitMatrix) extends Grid {
  private val cells = new BitMatrix(cellsState.rows, cellsState.columns)

  // Copy values to ensure immutability
  for (i <- 0 until cells.rows) {
    for (j <- 0 until cells.columns) {
      cells(i)(j) = cellsState(i)(j)
    }
  }

  override def rows: Int = cells.rows

  override def columns: Int = cells.columns


  override def apply(row: Int): GridRow = new GridRowImpl(row)

  class GridRowImpl(val row: Int) extends GridRow {
    def apply(column: Int): Boolean = cells(row)(column)
  }

}
