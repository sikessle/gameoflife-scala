package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

class FigureSpawnSpec extends UnitSpec {

  "spawnFigure(1,1)" should "spawn a figure at coordinates (1,1)" in {
    val grid = createGrid(10, 10)
    spawnFigure(grid, GliderFigure.coordinates, 1, 1)

    for (coord <- GliderFigure.coordinates) (i: Int, j: Int) =>
      assert(grid(i + 1)(j + 1))
  }
}