package com.epam.poker.scala

import scala.util.Try

object PokerService {
  def getWinner(playersBids:List[Option[Bid]], observersBids:List[Option[Bid]]) = {
    Try(
      playersBids
        .flatten
        .maxBy(_.amoutn)
    )
      .getOrElse(
        Try(
          observersBids
            .flatten
            .maxBy(_.amoutn)
        ).
          getOrElse("The is no winners")
      )
  }
}
