package org.sikessle.gameoflife.model

trait Figure {

  def name: String

  def coordinates: List[(Int, Int)]

}
