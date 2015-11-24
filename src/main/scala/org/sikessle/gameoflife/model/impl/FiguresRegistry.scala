package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Figure
import org.sikessle.gameoflife.model.impl.FigureDSL._

object FiguresRegistry {

  private val figures = Map(
    ("Glider", "Glider" hasCoordinates {
      List(
        0 -> 1,
        1 -> 2,
        2 -> 0,
        2 -> 1,
        2 -> 2
      )
    }),

    ("r-Pentomino", "r-Pentomino" hasCoordinates {
      List(
        0 -> 1,
        0 -> 2,
        1 -> 0,
        1 -> 1,
        2 -> 1
      )
    })
  )

  def apply(name: String): Figure = figures(name)

  def all: Iterable[Figure] = figures.values

}
