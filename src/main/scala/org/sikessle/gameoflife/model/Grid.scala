package org.sikessle.gameoflife.model

trait Grid {

  def rows: Int

  def columns: Int

  def apply(row: Int): GridRow


  trait GridRow {
    def apply(column: Int): Boolean
  }

}
