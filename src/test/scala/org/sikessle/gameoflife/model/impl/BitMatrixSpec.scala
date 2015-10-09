package org.sikessle.gameoflife.model.impl

import org.sikessle.gameoflife.UnitSpec

class BitMatrixSpec extends UnitSpec {
  val matrix = new BitMatrix(2, 2)

  "A BitMatrix" should "have only false cells" in {
    for (i <- 0 until matrix.rows) {
      for (j <- 0 until matrix.columns) {
        assert(!matrix(i)(j))
      }
    }
  }

  it should "be able to have false and true cells" in {
    matrix(0)(0) = true
    assert(matrix(0)(0))
    matrix(0)(0) = false
    assert(!matrix(0)(0))
  }
}