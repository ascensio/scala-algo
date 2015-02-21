package geometry.hulls

import org.salgo.geometry.hulls.QuickHull
import org.salgo.geometry.structures.Point2D
import org.scalatest.{FunSuite, Matchers}

class QuickHullSpec2D extends FunSuite with Matchers {
  test("Hull 2D with no points") { QuickHull.solve2D(Traversable.empty[Point2D]) should have size 0 }
  test("Hull 2D with one points") { QuickHull.solve2D(Seq(Point2D(1,1))) should contain only Point2D(1, 1) }
  test("Hull 2D with two points") { QuickHull.solve2D(Seq(Point2D(1,1), Point2D(1,2))) should contain theSameElementsAs Seq(Point2D(1, 1), Point2D(1,2)) }
  test("Hull 2D with three points") { QuickHull.solve2D(Seq(Point2D(1,1),Point2D(1,2),Point2D(2,2))) should contain theSameElementsAs Seq(Point2D(1, 1), Point2D(1,2),Point2D(2,2)) }
  test("Hull 2D for simple cloud") { QuickHull.solve2D(this.getPointsForSimpleCloud) should contain theSameElementsAs this.getExpectedPointsForSimpleCloud}
  test("Hull 2D for complex cloud") { QuickHull.solve2D(this.getPointsForComplexCloud) should contain theSameElementsAs this.getExpectedPointsForComplexCloud}

  private def getPointsForSimpleCloud: Traversable[Point2D] = {
    Point2D((5, 0),(0,-5),(-5, 0),(1, 1),(0, 5))
  }

  private def getExpectedPointsForSimpleCloud: Traversable[Point2D] = {
    Point2D((5, 0),(0,-5),(-5, 0),(0, 5))
  }

  private def getPointsForComplexCloud: Traversable[Point2D] = {
    Point2D((1,3),(2,4),(3,3),(3,8),(4,1),(4,5),(4,7),(6,3),(6,6),(6,8),(8,2),(8,5),(9,6))
  }

  private def getExpectedPointsForComplexCloud: Traversable[Point2D] = {
    Point2D((1,3),(3,8),(4,1),(6,8),(8,2),(9,6))
  }
}
