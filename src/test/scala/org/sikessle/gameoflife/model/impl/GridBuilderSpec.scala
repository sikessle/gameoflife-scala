package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec

import org.sikessle.gameoflife.model._

class GridBuilderSpec extends UnitSpec {

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

  it should "not build a grid with rows or columns less than 1" in {
    intercept[IllegalArgumentException] {
      GridBuilder.start(0, 1)
    }
    intercept[IllegalArgumentException] {
      GridBuilder.start(1, 0)
    }
  }

  "killAllCells" should "generate a dead grid" in {
    val constructibleGrid = GridBuilder.start(2, 1)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build
    val deadGrid = killAllCells(grid)

    assert(!deadGrid(0)(0))
  }

}