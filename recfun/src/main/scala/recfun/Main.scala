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
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceR(chars: List[Char], open: Int, close: Int): Boolean = {
      if(chars.isEmpty) open == close
      else if(open < close) false
      else if(chars.head == '(') balanceR(chars.tail, open + 1, close)
      else if(chars.head == ')') balanceR(chars.tail, open, close + 1)
      else balanceR(chars.tail, open, close)
    }
    balanceR(chars, 0, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeR(money: Int, coins: List[Int]): Int = {
      if(money == 0) 1
      else if(coins.isEmpty) 0
      else if(money < coins.head) countChangeR(money, coins.tail)
      else countChangeR(money - coins.head, coins) + countChangeR(money, coins.tail)
    }
    countChangeR(money, coins.sortWith(_ > _))
  }
}
