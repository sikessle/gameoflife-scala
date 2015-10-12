package org.sikessle.gameoflife.model.impl

import scala.collection.mutable

class BitMatrix(val rows: Int, val columns: Int) {
  private val matrix = new mutable.BitSet(rows * columns)

  require(rows >= 1 && columns >= 1)

  def apply(row: Int): BitRow = new BitRow(row)

  class BitRow(val row: Int) {
    def apply(column: Int): Boolean = matrix(row * columns + column)

    def update(column: Int, value: Boolean): Unit = matrix(row * columns + column) = value
  }

}

