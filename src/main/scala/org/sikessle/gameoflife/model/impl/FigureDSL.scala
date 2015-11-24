package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.Figure

object FigureDSL {

  implicit class FigureSpec(val figureName: String) {

    def hasCoordinates(figureCoords: List[(Int, Int)]): Figure = {
      new Figure {
        override def coordinates: List[(Int, Int)] = figureCoords

        override def name: String = figureName
      }
    }

  }

}

