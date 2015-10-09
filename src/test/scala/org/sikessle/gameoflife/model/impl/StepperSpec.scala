package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

class StepperSpec extends UnitSpec {

  "getStepper" should "return a valid stepper" in {
    assert(!getStepper.name.isEmpty)
  }

  "OriginalStepper" should "obey living cell rules" in {
    // must stay alive
    assert(OriginalStepper.nextStateOfLivingCell(2))
    assert(OriginalStepper.nextStateOfLivingCell(3))

    // must die
    assert(!OriginalStepper.nextStateOfLivingCell(1))
    assert(!OriginalStepper.nextStateOfLivingCell(4))
  }

  "OriginalStepper" should "obey dead cell rules" in {
    // must be reborn
    assert(OriginalStepper.nextStateOfDeadCell(3))

    // must stay dead
    assert(!OriginalStepper.nextStateOfDeadCell(2))
    assert(!OriginalStepper.nextStateOfDeadCell(4))
  }

  "AbstractStepper with AlwaysDeadStepper subclass" should "result on only dead cells" in {
    val constructibleGrid = GridBuilder.start(3, 3)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepNGenerations(grid, 1, AlwaysDeadStepper.step)
    assertEveryCellMatchesGivenValue(newGenGrid, false)
  }

  "AbstractStepper with AlwaysAliveStepper subclass" should "result on only living cells" in {
    val constructibleGrid = GridBuilder.start(3, 3)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepNGenerations(grid, 1, AlwaysAliveStepper.step)
    assertEveryCellMatchesGivenValue(newGenGrid, true)
  }

  def assertEveryCellMatchesGivenValue(grid: Grid, value: Boolean) = {
    for (i <- 0 until grid.rows) {
      for (j <- 0 until grid.columns) {
        assert(grid(i)(j) == value)
      }
    }
  }

}