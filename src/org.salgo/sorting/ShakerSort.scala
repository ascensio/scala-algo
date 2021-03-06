package org.salgo.sorting

import scala.reflect.ClassTag

object ShakerSort extends GeneralSortingAlgorithm {
  def sort[T <: Any : ClassTag](seq: Array[T])(implicit ev: T => Ordered[T]) : Unit = {
    var start = -1
    var end = seq.length - 2
    var swapped = false

    while (true) {
      start += 1
      for (i <- start to end) {
        if (seq(i) > seq(i + 1)) {
          this.swap(seq, i, i + 1)
          swapped = true
        }
      }

      if (!swapped) return
      swapped = false
      end = end - 1

      for (i <- end to start by -1) {
        if (seq(i) > seq(i + 1)) {
          this.swap(seq, i, i + 1)
          swapped = true
        }
      }

      if (!swapped) return
    }
  }
}
