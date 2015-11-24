package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

//noinspection NameBooleanParameters
class FiguresSpec extends UnitSpec {

  "A GliderFigure" should "have the name \"Glider\"" in {
    FiguresRegistry("Glider").name should be("Glider")
  }

  it should "have correct coordinates" in {
    val expectedCoords = List(
      (0, 1),
      (1, 2),
      (2, 0),
      (2, 1),
      (2, 2)
    )

    FiguresRegistry("Glider").coordinates should be(expectedCoords)
  }

  "A RPentominoFigure" should "have the name \"r-Pentomino\"" in {
    FiguresRegistry("r-Pentomino").name should be("r-Pentomino")
  }

  it should "have correct coordinates" in {
    val expectedCoords = List(
      (0, 1),
      (0, 2),
      (1, 0),
      (1, 1),
      (2, 1)
    )

    FiguresRegistry("r-Pentomino").coordinates should be(expectedCoords)
  }
}
