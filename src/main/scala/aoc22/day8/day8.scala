package zone.nora
package aoc22.day8

@main def main(): Unit = println(s"part 1: ${part1(inputSeq(8))} | part 2: ${part2(inputSeq(8))}")

def t(seq: Seq[String], x: Int, y: Int) =
  (seq(y)(x), seq(y).splitAt(x), seq.splitAt(y))

def f(x: Seq[Char]): Int = {
  val i = x.drop(1).indexWhere(_ >= x.head)
  if i >= 0 then i + 1 else x.size - 1
}

def part1(input: Seq[String]): Int = input.indices.map(y => input(y).indices.count { x =>
  val (tree, (r1, r2), (c1, c2)) = t(input, x, y)
  r1.forall(tree > _)
    || r2.drop(1).forall(tree > _)
    || c1.forall(tree > _(x))
    || c2.drop(1).forall(tree > _(x))
}).sum

def part2(input: Seq[String]): Int = input.indices.flatMap(y => input(y).indices.map { x =>
  val (_, (r1, r2), (c1, c2)) = t(input, x, y)
  f(r1.reverse.map(f => input(f)(x)))
    * f(r2.drop(1).map(f => input(f)(x)))
    * f(c1.indices.take(x + 1).reverse.map(f => input(y)(f)))
    * f(c2.drop(1).indices.drop(x).map(f => input(y)(f)))
}).max
