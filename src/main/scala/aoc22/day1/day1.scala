package zone.nora
package aoc22.day1

@main def main(): Unit =
  println(s"part 1: ${part1(input(1))} | part 2: ${part2(input(1))}")

def f(x: String): List[Int] =
  x.split("\n\n").map(_.split("\n").map(_.toInt).sum).toList

def part1(input: String): Int = f(input).max

def part2(input: String): Int = f(input).sorted.takeRight(3).sum
