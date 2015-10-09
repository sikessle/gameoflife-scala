package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Figure

object GliderFigure extends Figure {

  override def name: String = "Glider"

  override def coordinates: List[(Int, Int)] = {
    List(
      (0, 1),
      (1, 2),
      (2, 0),
      (2, 1),
      (2, 2)
    )
  }

}
