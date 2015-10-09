package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Grid

object GridBuilder {
  def start(rows: Int, columns: Int): Constructible = new Constructible(rows, columns)

  class Constructible(rows: Int, columns: Int) {

    private val cells = new BitMatrix(rows, columns)

    def apply(row: Int): ConstructibleRow = new ConstructibleRow(row)

    def build: Grid = new GridImpl(cells)

    class ConstructibleRow(val row: Int) {
      def apply(column: Int): Boolean = cells(row)(column)

      def update(column: Int, value: Boolean) = cells(row)(column) = value
    }

  }

}
