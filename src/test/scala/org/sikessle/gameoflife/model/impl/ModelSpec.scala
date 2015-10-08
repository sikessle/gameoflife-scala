package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec

class ModelSpec extends UnitSpec {

  val matrix = new BitMatrix(2, 2)

  "A BitMatrix" should "have only false cells" in {
    for (i <- 0 until matrix.rows) {
      for (j <- 0 until matrix.columns) {
        assert(!matrix(i)(j))
      }
    }
  }

  it should "be able to have false and true cells" in {
    matrix(0)(0) = true
    assert(matrix(0)(0))
    matrix(0)(0) = false
    assert(!matrix(0)(0))
  }

  "A GridBuilder" should "build a valid grid" in {
    val constructibleGrid = GridBuilder.start(2, 2)
    constructibleGrid(0)(0) = true
    constructibleGrid(1)(0) = true
    val grid = constructibleGrid.build

    assert(grid.rows == 2 && grid.columns == 2)
    assert(grid(0)(0))
    assert(grid(1)(0))
    assert(!grid(0)(1))
    assert(!grid(1)(1))
  }

}