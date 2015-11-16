package org.sikessle.gameoflife

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import org.sikessle.gameoflife.controller.Controller
import org.sikessle.gameoflife.controller.impl.GridControllerImpl
import org.sikessle.gameoflife.model.{GridFactory, Stepper, Grid}
import org.sikessle.gameoflife.model.impl.{GridFactoryImpl, OriginalStepper, GridImpl}

class BaseModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[Controller].to[GridControllerImpl]
    bind[Stepper].to[OriginalStepper]
    bind[GridFactory].to[GridFactoryImpl]
  }
}
