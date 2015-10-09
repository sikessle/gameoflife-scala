package org.sikessle.gameoflife.controller

import java.util.Observable

import org.sikessle.gameoflife.model.{Figure, Grid}

trait Controller extends Observable {

  def grid: Grid

  def killAllCells(): Unit

  def setGridSize(rows: Int, columns: Int): Unit

  def stepNGenerations(n: Int): Unit

  def setCellToLivingAtPosition(row: Int, column: Int): Unit

  def setCellToDeadAtPosition(row: Int, column: Int): Unit

  def spawnFigure(figure: Figure, row: Int, column: Int): Unit

  def steppedGenerations: Int

  def stepperName: String
}
