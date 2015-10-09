package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.{Grid, Stepper}

object OriginalStepper extends AbstractStepper {

  private val AliveToDeadMinNeighbors = 2
  private val AliveToDeadMaxNeighbors = 3
  private val DeadToAliveNeighbors = 3

  override def name: String = "Original World (23/3)"

  override def nextStateOfLivingCell(livingNeighbors: Int): Boolean = {
    livingNeighbors >= AliveToDeadMinNeighbors && livingNeighbors <= AliveToDeadMaxNeighbors
  }

  override def nextStateOfDeadCell(livingNeighbors: Int): Boolean = {
    livingNeighbors == DeadToAliveNeighbors
  }
}
