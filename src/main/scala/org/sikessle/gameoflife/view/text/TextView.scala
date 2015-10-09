package org.sikessle.gameoflife.view.text

import java.util.{Observable, Observer}

import org.sikessle.gameoflife.controller.Controller

import scala.collection.mutable


class TextView(val controller: Controller) extends Observer {

  private val additionalHeaderOutput = new mutable.Queue[String]
  private val scanner = new java.util.Scanner(System.in)
  private val commandsChain = new CommandsChain

  redraw()

  def readAndInterpretInLoopFromInputStream(): Unit = {
    while (controller.gameRunning) {
      readAndInterpretFromInputStream()
    }
  }

  def readAndInterpretFromInputStream(): Unit = {
    if (scanner.hasNextLine) {
      val line = scanner.nextLine()
      interpretLine(line)
    }
  }

  def readAndInterpretFromArgument(line: String): Unit = {
    interpretLine(line)
  }

  private def interpretLine(line: String): Unit = {
    var command = getCommand(line)
    val arguments = getArguments(line)
    commandsChain.handle(this, command, arguments)
  }

  private def getCommand(line: String): String = {
    line.split(" ")(0)
  }

  private def getArguments(line: String): Args = {
    val indexOfFirstSpace = line.indexOf(' ')
    val argsPart = if (indexOfFirstSpace < 0) "" else line.substring(indexOfFirstSpace)

    new Args(argsPart)
  }

  def quit(): Unit = {
    controller.quitGame
  }

  def addLineToHeaderOutput(header: String): Unit = additionalHeaderOutput += header

  override def update(o: Observable, arg: scala.Any): Unit = {
    redraw()
  }


  private def redraw(): Unit = {
    val grid = controller.grid

    drawLineBreak()
    drawAndFlushAdditionalHeaderOutput()
    drawLineBreak()
    drawGenerationStrategy()
    drawLineBreak()
    drawHorizontalBorder()

    for (i <- 0 until grid.rows) {
      drawVerticalBorder()
      for (j <- 0 until grid.columns) {
        drawCell(grid(i)(j))
      }
      drawVerticalBorder()
      drawLineBreak()
    }

    drawHorizontalBorder()
    drawLineBreak()
    drawAvailableCommands()
  }

  private def drawVerticalBorder(): Unit = {
    writeOut("|")
  }

  private def drawHorizontalBorder(): Unit = {
    val length = controller.grid.columns
    drawVerticalBorder()
    for (i <- 0 until length) {
      writeOut("-")
    }
    drawVerticalBorder()
    drawLineBreak()
  }

  private def drawAvailableCommands(): Unit = {
    val commandDescriptions = commandsChain.getAllCommandDescriptions
    writeOut("Commands: ")
    drawLineBreak()
    for (command <- commandDescriptions) {
      writeOut(command)
      drawLineBreak()
    }
  }

  private def drawAndFlushAdditionalHeaderOutput(): Unit = {
    for (header <- additionalHeaderOutput) {
      writeOut(header)
      drawLineBreak()
    }
    additionalHeaderOutput.clear()
  }

  private def drawGenerationStrategy(): Unit = {
    writeOut("Generation World: ")
    writeOut(controller.stepperName)
  }

  private def drawCell(alive: Boolean): Unit = writeOut(if (alive) "#" else " ")

  private def writeOut(text: String): Unit = print(text)

  private def drawLineBreak(): Unit = writeOut(System.lineSeparator)

}
