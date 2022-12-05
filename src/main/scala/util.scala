package zone.nora

import java.io.File
import scala.io.Source
import scala.util.{Try, Using}

def input(day: Int): String =
  Using(Source.fromFile(s"input/day$day/input.txt")) { _.mkString }.get
