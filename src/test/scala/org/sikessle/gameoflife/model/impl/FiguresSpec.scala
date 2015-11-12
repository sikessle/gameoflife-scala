package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

//noinspection NameBooleanParameters
class FiguresSpec extends UnitSpec {

  "A GliderFigure" should "have the name \"Glider\"" in {
    GliderFigure.name should be("Glider")
  }

  it should "have correct coordinates" in {
    val expectedCoords = List(
      (0, 1),
      (1, 2),
      (2, 0),
      (2, 1),
      (2, 2)
    )

    GliderFigure.coordinates should be(expectedCoords)
  }

  "A RPentominoFigure" should "have the name \"r-Pentomino\"" in {
    RPentominoFigure.name should be("r-Pentomino")
  }

  it should "have correct coordinates" in {
    val expectedCoords = List(
      (0, 1),
      (0, 2),
      (1, 0),
      (1, 1),
      (2, 1)
    )

    RPentominoFigure.coordinates should be(expectedCoords)
  }
}
