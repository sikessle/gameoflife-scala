package org.sikessle.gameoflife.model.impl

import com.google.inject.Guice
import org.sikessle.gameoflife.BaseModule
import org.sikessle.gameoflife.model.{GridFactory, Grid}

object GridBuilder {

  private val injector = Guice.createInjector(new BaseModule)

  def start(rows: Int, columns: Int): Constructible = new Constructible(rows, columns)

  def start(grid: Grid): Constructible = start(grid.rows, grid.columns)

  def copy(grid: Grid): Constructible = copy(grid, grid.rows, grid.columns)

  def copy(grid: Grid, newRows: Int, newColumns: Int): Constructible = {
    val newGrid = start(newRows, newColumns)
    val copyRowsUntil = math.min(newRows, grid.rows)
    val copyColumnsUntil = math.min(newColumns, grid.columns)

    for (i <- 0 until copyRowsUntil) {
      for (j <- 0 until copyColumnsUntil) {
        newGrid(i)(j) = grid(i)(j)
      }
    }
    newGrid
  }

  class Constructible(gridRows: Int, gridColumns: Int) {

    private val cells = new BitMatrix(gridRows, gridColumns)

    def rows: Int = cells.rows

    def columns: Int = cells.columns

    def apply(row: Int): ConstructibleRow = new ConstructibleRow(row)

    def build: Grid = {
      import net.codingwell.scalaguice.InjectorExtensions._
      val factory = injector.instance[GridFactory]
      factory.build(cells)
    }

    class ConstructibleRow(val row: Int) {
      def apply(column: Int): Boolean = cells(row)(column)

      def update(column: Int, value: Boolean) = cells(row)(column) = value
    }

  }

}
