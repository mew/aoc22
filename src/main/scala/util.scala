package zone.nora

import scala.io.Source
import scala.util.{Try, Using}

def input(day: Int): String = 
  Using(Source.fromFile(s"input/day$day/input.txt")) { _.mkString }.get

def inputSeq(day: Int): Seq[String] = input(day).split("\n")
