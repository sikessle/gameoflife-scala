package org.sikessle.gameoflife.controller

import java.util.Observable

import org.sikessle.gameoflife.model.{Figure, Grid}

trait Controller extends Observable {

  def quitGame(): Unit

  def grid: Grid

  def gameRunning: Boolean

  def killAllCells(): Unit

  def setGridSize(rows: Int, columns: Int): Unit

  def stepOneGeneration(): Unit

  def setCellToLivingAtPosition(row: Int, column: Int): Unit

  def setCellToDeadAtPosition(row: Int, column: Int): Unit

  def spawnFigure(figure: Figure, row: Int, column: Int): Unit

  def steppedGenerations: Int

  def stepperName: String
}
