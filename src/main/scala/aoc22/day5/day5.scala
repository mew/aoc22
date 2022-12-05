package zone.nora
package aoc22.day5

import scala.::
import scala.collection.mutable

@main def main(): Unit = {
  val in = input(5).split("\n")
  def setup(): Unit = {
    stacks.clear()
    in.splitAt(8)._1.foreach(x =>
      (1 :: 5 :: 9 :: 13 :: 17 :: 21 :: 25 :: 29 :: 33 :: Nil).zipWithIndex.map(f => (f._1, f._2 + 1)).foreach(f =>
        if (f._1 < x.length) {
          val c = x.charAt(f._1)
          if (c != ' ') stacks.put(f._2, stacks.getOrElse(f._2, List.empty) :+ c)
        }
      )
    )
  }
  setup()
  val moves = in.splitAt(10)._2.map { line =>
    val Array(x, y, z) = line.split("\\D+").tail.map(_.toInt)
    Move(x, y, z)
  }
  print(s"part 1: ${part1(moves)} |")
  setup()
  println(s" part 2: ${part2(moves)}")
}

case class Move(num: Int, from: Int, to: Int)

val stacks = mutable.HashMap[Int, List[Char]]()

def f(x: Move): Unit = {
  val f = stacks(x.from)
  val c = f.take(x.num)
  stacks.put(x.from, f.drop(x.num))
  stacks.put(x.to, c ++ stacks(x.to))
}

def part1(input: Array[Move]): String = {
  input.foreach(m => 1 to m.num foreach(_ => f(Move(1, m.from, m.to))))
  stacks.values.map(f => f.head).mkString
}

def part2(input: Array[Move]): String = {
  input.foreach(m => f(m))
  stacks.values.map(f => f.head).mkString
}
