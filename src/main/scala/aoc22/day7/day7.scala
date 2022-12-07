package zone.nora
package aoc22.day7

import scala.annotation.tailrec

@main def main(): Unit = println(s"part 1: $part1 | part 2: $part2")

case class Files(dir: List[String], ds: Map[List[String], Int])

val in: Map[List[String], Int] =
  input(7).split("\n").foldLeft(Files(List("/"), Map()))(cmd).ds

@tailrec def f(x: Files, y: Int, z: List[String]): Files =
  if (z == Nil) x else f(x.copy(ds = x.ds.updated(z, x.ds.getOrElse(z, 0) + y)), y, z.init)

def cmd(x: Files, y: String): Files = y match
  case "$ ls" | s"dir ${_}" => x
  case "$ cd .." => x.copy(x.dir.init)
  case s"$$ cd ${z}" => x.copy(x.dir :+ z)
  case s"${z} ${_}" => f(x, z.toInt, x.dir)

def part1: Int = in.values.filter(_ <= 100000).sum
def part2: Int = in.values.filter(_ >= (30000000 - (70000000 - in(List("/"))))).min
