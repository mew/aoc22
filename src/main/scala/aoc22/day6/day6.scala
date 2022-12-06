package zone.nora
package aoc22.day6

@main def main(): Unit =
  println(s"part 1: ${part1(input(6))} | part 2: ${part2(input(6))}")

def f(x: String, y: Int): Int = x.sliding(y).indexWhere(_.distinct.length == y) + y

def part1(input: String): Int = f(input, 4)

def part2(input: String): Int = f(input, 14)

