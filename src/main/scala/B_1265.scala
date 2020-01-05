import scala.io.StdIn._

object B_1265 extends App {
  val t = readInt()
  1 to t foreach { _ =>
    val n = readInt()
    val A = readLine().split(" ").map(_.toInt)
    val pos = A.zipWithIndex.toMap

    var posMax = pos(1)
    var posMin = pos(1)
    val result = Array.fill(n)(false)
    result(0) = true

    2 to n foreach { m =>
      posMax = Math.max(posMax, pos(m))
      posMin = Math.min(posMin, pos(m))
      result(posMax - posMin) = posMax - posMin + 1 == m
//      println(s"$m -> ($posMin, $posMax)")
    }

    println(result.map(x => if (x) "1" else "0").mkString)
    //100000000000000000000001

  }
}
