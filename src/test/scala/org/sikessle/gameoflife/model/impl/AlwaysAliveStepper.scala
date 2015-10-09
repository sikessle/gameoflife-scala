package org.sikessle.gameoflife.model.impl

object AlwaysAliveStepper extends AbstractStepper {
  override def name: String = "Always Alive"

  override def nextStateOfLivingCell(livingNeighbors: Int): Boolean = true

  override def nextStateOfDeadCell(livingNeighbors: Int): Boolean = true
}
