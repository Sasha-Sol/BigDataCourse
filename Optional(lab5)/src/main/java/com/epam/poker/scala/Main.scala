package com.epam.poker.scala

object Main {

  def main(args: Array[String]): Unit = {

    var playersBids: List[Option[Bid]] = List.tabulate(10)(n => if (n % 2 == 1) Some(Bid("Player Alex" + n, n * 500)) else None)
    var observersBid: List[Option[Bid]] = List.tabulate(10)(n => if (n % 2 == 1) Some(Bid("Observer John" + n, n * 1000)) else None)
    var emptyBids: List[Option[Bid]] = List(None, None)

    println(PokerService.getWinner(playersBids, observersBid))
    println(PokerService.getWinner(emptyBids, observersBid))
    println(PokerService.getWinner(emptyBids, emptyBids))

  }

}
