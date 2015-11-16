package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.model._

//noinspection NameBooleanParameters
class StepperSpec extends UnitSpec {

  "getStepper" should "return a valid stepper" in {
    getStepper.name.isEmpty should be(false)
  }

  "OriginalStepper" should "count living neighbors = 0 on dead grid" in {
    val grid = createGrid(2, 2)

    val stepper = new OriginalStepper

    stepper.countLivingNeighbors(grid, 0, 0) should be(0)
    stepper.countLivingNeighbors(grid, 0, 1) should be(0)
    stepper.countLivingNeighbors(grid, 1, 0) should be(0)
    stepper.countLivingNeighbors(grid, 1, 1) should be(0)
  }

  "OriginalStepper count in row" should "count 2" in {
    val constructible = GridBuilder.start(3, 3)
    // X _ X
    constructible(1)(0) = true
    constructible(1)(2) = true
    val grid = constructible.build
    val stepper = new OriginalStepper

    stepper.countLivingNeighborsInRow(grid, 1, 1, 1) should be(2)
  }

  "OriginalStepper" should "count living neighbors = 3 on living grid" in {
    val constructible = GridBuilder.start(2, 2)
    constructible(1)(0) = true

    val grid = constructible.build
    val stepper = new OriginalStepper

    stepper.countLivingNeighbors(grid, 0, 0) should be(1)
    stepper.countLivingNeighbors(grid, 0, 1) should be(1)
    stepper.countLivingNeighbors(grid, 1, 0) should be(0)
    stepper.countLivingNeighbors(grid, 1, 1) should be(1)
  }

  "OriginalStepper" should "should leave a dead grid dead after 1 step" in {
    val grid = createGrid(2, 2)
    val stepper = new OriginalStepper
    val newGrid = stepper.step(grid)

    everyCellShouldBe(newGrid, value = false)
  }

  "OriginalStepper" should "obey living cell rules" in {
    val stepper = new OriginalStepper

    // must stay alive
    stepper.nextStateOfLivingCell(2) should be(true)
    stepper.nextStateOfLivingCell(3) should be(true)

    // must die
    stepper.nextStateOfLivingCell(1) should be(false)
    stepper.nextStateOfLivingCell(4) should be(false)
  }

  "OriginalStepper" should "obey dead cell rules" in {
    val stepper = new OriginalStepper

    // must be reborn
    stepper.nextStateOfDeadCell(3) should be(true)

    // must stay dead
    stepper.nextStateOfDeadCell(2) should be(false)
    stepper.nextStateOfDeadCell(4) should be(false)
  }

  "AbstractStepper with AlwaysDeadStepper subclass" should "result on only dead cells" in {
    val constructibleGrid = GridBuilder.start(3, 3)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepOneGeneration(grid, AlwaysDeadStepper.step)
    everyCellShouldBe(newGenGrid, value = false)
  }

  "AbstractStepper with AlwaysAliveStepper subclass" should "result on only living cells" in {
    val constructibleGrid = GridBuilder.start(3, 3)
    constructibleGrid(0)(0) = true
    val grid = constructibleGrid.build

    val newGenGrid = stepOneGeneration(grid, AlwaysAliveStepper.step)
    everyCellShouldBe(newGenGrid, value = true)
  }

  "AbstractStepper with OriginalStepper subclass" should "obey the original rules" in {
    val constructibleGrid = GridBuilder.start(10, 10)
    constructibleGrid(5)(4) = true
    constructibleGrid(5)(5) = true
    constructibleGrid(5)(6) = true
    val grid = constructibleGrid.build
    val stepper = new OriginalStepper

    val newGenGrid = stepOneGeneration(grid, stepper.step)
    // must oscillate
    newGenGrid(4)(5) should be(true)
    newGenGrid(5)(5) should be(true)
    newGenGrid(6)(5) should be(true)
  }

  def everyCellShouldBe(grid: Grid, value: Boolean) = {
    for (i <- 0 until grid.rows) {
      for (j <- 0 until grid.columns) {
        grid(i)(j) should be(value)
      }
    }
  }

}