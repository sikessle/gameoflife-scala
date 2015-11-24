package org.sikessle.gameoflife.controller.impl

import java.util.{Observable, Observer}

import org.sikessle.gameoflife.UnitSpec
import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.model.impl.FiguresRegistry

class GridControllerImplSpec extends UnitSpec {

  "Modifying state" should "trigger an update to all observers" in {
    testObserverCalled((controller: Controller) => controller.stepOneGeneration())
    testObserverCalled((controller: Controller) => controller.spawnFigure(FiguresRegistry("Glider"), 0, 0))
    testObserverCalled((controller: Controller) => controller.setCellToLivingAtPosition(0, 0))
    testObserverCalled((controller: Controller) => controller.setCellToDeadAtPosition(0, 0))
    testObserverCalled((controller: Controller) => controller.killAllCells())
    testObserverCalled((controller: Controller) => controller.setGridSize(2, 2))
  }

  def testObserverCalled(command: Controller => Unit): Unit = {
    val controller = new GridControllerImpl()
    var observerCalled = false

    controller.addObserver(new Observer {
      override def update(o: Observable, arg: scala.Any): Unit = {
        observerCalled = true
      }
    })

    command(controller)

    observerCalled should be(true)
  }

  "Getters and Setters" should "return correct values" in {
    val controller = new GridControllerImpl()
    controller.gameRunning should be(true)
    controller.quitGame()
    controller.gameRunning should be(false)

    controller.stepperName shouldNot be(empty)

    controller.stepOneGeneration()
    controller.steppedGenerations should be(1)
  }

}
