package zone.nora
package aoc22.day2

@main def main(): Unit =
  println(s"part 1: ${part1(input(2))} | part 2: ${part2(input(2))}")

// oh no
val y = Map(
  "A X" -> (4, 3), "A Y" -> (8, 4), "A Z" -> (3, 8),
  "B X" -> (1, 1), "B Y" -> (5, 5), "B Z" -> (9, 9),
  "C X" -> (7, 2), "C Y" -> (2, 6), "C Z" -> (6, 7)
)

def part1(input: String): Int = input.split("\n").map(y(_)._1).sum

def part2(input: String): Int = input.split("\n").map(y(_)._2).sum
