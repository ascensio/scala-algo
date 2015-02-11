package org.sortex

object InsertionSort extends SortingAlgorithm {
  def sort[T](seq: Array[T])(implicit converter: T => Ordered[T]) : Unit = {
    for (i <- 1 to seq.length - 1) {
      for (k <- i to 1 by -1 if k > 0) {
        val current = seq(k)
        val previous = seq(k-1)
        if (current < previous) {
          seq.update(k, previous)
          seq.update(k-1, current)
        }
      }
    }
  }
}


