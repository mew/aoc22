package zone.nora
package aoc22.day4

@main def main(): Unit =
  println(s"part 1: ${part1(input(4))} | part 2: ${part2(input(4))}")

def f(x: String) = x.split("\n").map(_.split(',').map { r =>
  val a = r.split('-').map(_.toInt)
  Range.inclusive(a(0), a(1)).toSet
})

def part1(input: String): Int =
  f(input).count(p => p(0).subsetOf(p(1)) || p(1).subsetOf(p(0)))

def part2(input: String): Int =
  f(input).count(p => p(0).intersect(p(1)).nonEmpty)

