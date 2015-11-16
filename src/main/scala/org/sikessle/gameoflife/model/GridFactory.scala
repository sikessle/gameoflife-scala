package org.sikessle.gameoflife.model

import org.sikessle.gameoflife.model.impl.BitMatrix

trait GridFactory {

  def build(cells: BitMatrix): Grid

}
