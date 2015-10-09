package org.sikessle.gameoflife.model

trait Stepper {
  def step(grid: Grid): Grid

  def name: String
}
