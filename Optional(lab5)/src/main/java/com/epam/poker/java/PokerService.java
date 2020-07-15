package com.epam.poker.java;

import java.util.Comparator;
import java.util.List;
import java.util.Observer;
import java.util.Optional;

public class PokerService {
    public static void getWinner(List<Optional<Bid>> playerBids, List<Optional<Bid>> observersBids) {

        playerBids.stream().
                flatMap(Optional::stream).
                max(Comparator.comparingInt(Bid::getAmount))
                .or(() ->
                        observersBids.stream()
                                .flatMap(Optional::stream)
                                .max(Comparator.comparingInt(Bid::getAmount))
                )
                .ifPresent(bidder -> System.out.println("The bidder " + bidder.getBidder() + " Won!"));
//        Optional.of(
//                playerBids.stream()
//                        .flatMap(Optional::stream)
//                        .max(Comparator.comparingInt(Bid::getAmount))
//                        .get()
//                        .getBidder()
//        )
//                .or(() ->
//                        Optional.of(
//                                playerBids.stream()
//                                        .flatMap(Optional::stream)
//                                        .max(Comparator.comparingInt(Bid::getAmount))
//                                        .get()
//                                        .getBidder()
//                        )
//                );
    }
}
