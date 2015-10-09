package org.sikessle.gameoflife.model.impl

object AlwaysDeadStepper extends AbstractStepper {
  override def name: String = "Always Dead"

  override def nextStateOfLivingCell(livingNeighbors: Int): Boolean = false

  override def nextStateOfDeadCell(livingNeighbors: Int): Boolean = false
}
