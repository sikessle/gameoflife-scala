package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.model.{Grid, GridFactory}

class GridFactoryImpl extends GridFactory {
  override def build(cells: BitMatrix): Grid = {
    new GridImpl(cells)
  }
}
