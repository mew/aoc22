package zone.nora
package aoc22.day3

@main def main(): Unit =
  println(s"part 1: ${part1(input(3))} | part 2: ${part2(input(3))}")

def priority(x: Char) = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(x)

def part1(input: String): Int = input.split("\n").map { x =>
  val s = x.splitAt(x.length >> 1)
  priority(s._1.intersect(s._2)(0))
}.sum

def part2(input: String): Int =
  input.split("\n").grouped(3).map(x => priority(x(0).intersect(x(1)).intersect(x(2))(0))).sum

