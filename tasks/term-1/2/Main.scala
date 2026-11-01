package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("\nParentheses Balancing")
    println(s"(a + b) * (c - d): ${balance("(a + b) * (c - d)".toList)}")
    println(s"())(: ${balance("())(".toList)}")
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    (c, r) match {
      case (column, row) if column < 0 || row < 0 || column > row =>
        0
      case (column, row) if column == 0 || column == row =>
        1
      case (column, row) =>
        pascal(column - 1, row - 1) + pascal(column, row - 1)
    }
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def loop(remaining: List[Char], opened: Int): Boolean = {
      remaining match {
        case Nil =>
          opened == 0
        case '(' :: tail =>
          loop(tail, opened + 1)
        case ')' :: _ if opened == 0 =>
          false
        case ')' :: tail =>
          loop(tail, opened - 1)
        case _ :: tail =>
          loop(tail, opened)
      }
    }

    loop(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {

  }
  
  /**
   * Excerice 4 N-Queens Problem
   * Write a function that provides a solution for n-queens problem if possible
   * Input parameter represents board size and number of queens
   * Output is an array: index represents row number and value represents column number.
   * Example: nQueens(4): [1,3,0,2] or
   * 0 1 0 0
   * 0 0 0 1
   * 1 0 0 0
   * 0 0 1 0
   */

  def nQueens(size: Int): Option[Array[Int]] = {

  }

}
