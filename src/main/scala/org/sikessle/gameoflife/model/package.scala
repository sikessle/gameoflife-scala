package org.sikessle.gameoflife

import org.sikessle.gameoflife.model.impl.{GridBuilder, OriginalStepper}

package object model {
  def getStepper: Stepper = OriginalStepper

  def stepNGenerations(grid: Grid, generations: Int, stepper: Grid => Grid): Grid = {
    var result = grid
    for (i <- 0 until generations) {
      result = stepper(result)
    }
    result
  }

  def killAllCells(grid: Grid): Grid = GridBuilder.start(grid).build()

}


//
//void spawnFigure(Figure figure, int row, int column);
//

