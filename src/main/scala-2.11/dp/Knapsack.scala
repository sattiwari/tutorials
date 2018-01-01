package dp



object Knapsack extends App {

  private def printOutput(mat: Array[Array[Int]]): Unit = {
    mat.foreach { row =>
      row.foreach { col =>
        print(s"${col}\t")
      }
      println()
    }
  }

  def knapsack(weights: List[Int], values: List[Int], maxWeight: Int): Int = {
    val n = weights.length
    var sol = Array.fill(maxWeight+1)(0)

    (1 to n) foreach { i =>
      val newSol = Array.fill(maxWeight+1)(0)
      (1 to maxWeight) foreach { j =>
        newSol(j) =
          if(weights(i-1) < j) Math.max(values(i-1) + sol(j-weights(i-1)), sol(j))
          else sol(j)
        print(s"${newSol(j)}\t")
      }
      sol = newSol
      println()
    }
    sol(maxWeight)
  }

  val weights = List(1, 2, 4, 2, 3)
  val values = List(3, 3, 5, 3, 7)
  val maxWeight = 9

  knapsack(weights, values, maxWeight)
}
