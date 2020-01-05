import scala.io.StdIn

object A_1265 extends App {

  def isGood(line: Array[Char]): String = {
    line.indices foreach { i =>
      if (line(i) != '?') {
        val prev = if (i > 0) Some(line(i - 1)) else None
        if (prev.nonEmpty && prev.get == line(i)) return ""
      }
      else {
        val prev = if (i > 0) Some(line(i - 1)) else None
        val next = if (i < line.length - 1) Some(line(i + 1)) else None
        val good = List('a', 'b', 'c').filterNot(x => List(prev.getOrElse('?'), next.getOrElse('?')).contains(x))
        line(i) = good.head
      }
    }

    line.mkString
  }

  val n = StdIn.readInt()
  1 to n foreach { _ =>
    val line = StdIn.readLine().toCharArray
    val answer = isGood(line)
    if (answer == "") println(-1) else println(answer)
  }
}
