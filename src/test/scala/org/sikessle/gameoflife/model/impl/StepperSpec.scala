package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

class StepperSpec extends UnitSpec {

  "getStepper" should "return a valid stepper" in {
    assert(!getStepper.name.isEmpty)
  }

  "OriginalStepper" should "count living neighbors = 0 on dead grid" in {
    val grid = createGrid(2, 2)
    assert(OriginalStepper.countLivingNeighbors(grid, 0, 0) == 0)
    assert(OriginalStepper.countLivingNeighbors(grid, 0, 1) == 0)
    assert(OriginalStepper.countLivingNeighbors(grid, 1, 0) == 0)
    assert(OriginalStepper.countLivingNeighbors(grid, 1, 1) == 0)
  }

  "OriginalStepper count in row" should "count 2" in {
    val constructible = GridBuilder.start(3, 3)
    // X _ X
    constructible(1)(0) = true
    constructible(1)(2) = true
    val grid = constructible.build

    assert(OriginalStepper.countLivingNeighborsInRow(grid, 1, 1, 1) == 2)
  }

  "OriginalStepper" should "count living neighbors = 3 on living grid" in {
    val constructible = GridBuilder.start(2, 2)
    constructible(1)(0) = true

    val grid = constructible.build

    assert(OriginalStepper.countLivingNeighbors(grid, 0, 0) == 1)
    assert(OriginalStepper.countLivingNeighbors(grid, 0, 1) == 1)
    assert(OriginalStepper.countLivingNeighbors(grid, 1, 0) == 0)
    assert(OriginalStepper.countLivingNeighbors(grid, 1, 1) == 1)
  }

  "OriginalStepper" should "should leave a dead grid dead after 1 step" in {
    val grid = createGrid(2, 2)
    val newGrid = OriginalStepper.step(grid)

    assertEveryCellMatchesGivenValue(newGrid, value = false)
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

    val newGenGrid = stepOneGeneration(grid, AlwaysDeadStepper.step)
    assertEveryCellMatchesGivenValue(newGenGrid, value = false)
  }

  "AbstractStepper with AlwaysAliveStepper subclass" should "result on only living cells" in {
    val constructibleGrid = GridBuilder.start(3, 3)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepOneGeneration(grid, AlwaysAliveStepper.step)
    assertEveryCellMatchesGivenValue(newGenGrid, value = true)
  }

  "AbstractStepper with OriginalStepper subclass" should "obey the original rules" in {
    val constructibleGrid = GridBuilder.start(10, 10)
    constructibleGrid(5)(4) = true
    constructibleGrid(5)(5) = true
    constructibleGrid(5)(6) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepOneGeneration(grid, OriginalStepper.step)
    // must oscillate
    assert(newGenGrid(4)(5))
    assert(newGenGrid(5)(5))
    assert(newGenGrid(6)(5))
  }

  def assertEveryCellMatchesGivenValue(grid: Grid, value: Boolean) = {
    for (i <- 0 until grid.rows) {
      for (j <- 0 until grid.columns) {
        assert(grid(i)(j) == value)
      }
    }
  }

}