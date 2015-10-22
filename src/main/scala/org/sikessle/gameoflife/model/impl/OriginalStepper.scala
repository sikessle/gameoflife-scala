package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.{Grid, Stepper}

object OriginalStepper extends AbstractStepper {

  override def name: String = "Original World (23/3)"

  override def nextStateOfLivingCell(livingNeighbors: Int): Boolean = {
    livingNeighbors == 2 || livingNeighbors == 3
  }

  override def nextStateOfDeadCell(livingNeighbors: Int): Boolean = {
    livingNeighbors == 3
  }
}
