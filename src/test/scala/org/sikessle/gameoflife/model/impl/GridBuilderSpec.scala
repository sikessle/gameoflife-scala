package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec

import org.sikessle.gameoflife.model._

//noinspection NameBooleanParameters
class GridBuilderSpec extends UnitSpec {

  "A GridBuilder" should "build a valid grid" in {
    val constructibleGrid = GridBuilder.start(2, 2)
    constructibleGrid(0)(0) = true
    constructibleGrid(1)(0) = true

    val grid = constructibleGrid.build

    grid.rows should be(2)
    grid.columns should be(2)

    grid(0)(0) should be(true)
    grid(1)(0) should be(true)
    grid(0)(1) should be(false)
    grid(1)(1) should be(false)
  }

  it should "not build a grid with rows or columns less than 1" in {
    intercept[IllegalArgumentException] {
      GridBuilder.start(0, 1)
    }
    intercept[IllegalArgumentException] {
      GridBuilder.start(1, 0)
    }
  }

  "A ConstructibleGrid" should "have valid rows, columns properties" in {
    val constructibleGrid = GridBuilder.start(2, 2)

    constructibleGrid.rows should be(2)
    constructibleGrid.columns should be(2)
  }

  "A ConstructibleRow" should "have getters and setters for columns" in {
    val constructibleRow = GridBuilder.start(2, 2)(0)

    constructibleRow(0) = true
    constructibleRow(0) should be (true)
  }

  "killAllCells" should "generate a dead grid" in {
    val constructibleGrid = GridBuilder.start(2, 1)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build
    val deadGrid = killAllCells(grid)

    deadGrid(0)(0) should be(false)
  }

}