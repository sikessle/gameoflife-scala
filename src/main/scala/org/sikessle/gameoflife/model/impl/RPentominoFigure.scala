package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Figure

object RPentominoFigure extends Figure {

  override def name: String = "r-Pentomino"

  override def coordinates: List[(Int, Int)] = {
    List(
      (0, 1),
      (0, 2),
      (1, 0),
      (1, 1),
      (2, 1)
    )
  }

}
