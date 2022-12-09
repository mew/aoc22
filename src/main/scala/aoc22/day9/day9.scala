package zone.nora
package aoc22.day9

import scala.annotation.targetName

@main def main(): Unit =
  println(s"part 1: ${part1(inputSeq(9))} | part 2: ${part2(inputSeq(9))}")

case class Point(x: Int, y: Int):
  @targetName("minus") infix def -(other: Point): Point = Point(x - other.x, y - other.y)
  @targetName("plus") infix def +(other: Point): Point = Point(x + other.x, y + other.y)
  def sign(): Point = Point(x.sign, y.sign)
  infix def touches(other: Point): Boolean = this - other match
    case Point(x_, y_) => x_.abs <= 1 && y_.abs <= 1

def f(in: Seq[String], knots: Int): Int = in.flatMap { case s"$a $b" => Seq.fill(b.toInt)(a match
  case "U" => Point(0, 1)
  case "D" => Point(0, -1)
  case "R" => Point(1, 0)
  case "L" => Point(-1, 0))
}.scanLeft(Seq.fill(knots)(Point(0, 0)))(
  (x, y) => x.tail.scanLeft(x.head + y)
  ((p1, p2) => if p1 touches p2 then p2 else p2 + (p1 - p2).sign())
).map(_.last).distinct.size

def part1(input: Seq[String]): Int = f(input, 2)

def part2(input: Seq[String]): Int = f(input, 10)
