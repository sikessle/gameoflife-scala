package org.sikessle.gameoflife.view.text

class ClearGridCommand extends Command {

   private val Key = "c"
   private val Description = "clear"

   override def toString: String = Key + ": " + Description

   override protected def isResponsible(command: String, arguments: Args): Boolean = {
     command.equals(Key) && arguments.size == 0
   }

   override protected def execute(textView: TextView, arguments: Args): Unit = {
     textView.controller.killAllCells()
   }
 }
