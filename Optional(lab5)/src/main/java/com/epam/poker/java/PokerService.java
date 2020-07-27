package com.epam.poker.java;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PokerService {
    public static Optional<Bid> getWinner(List<Optional<Bid>> playerBids, List<Optional<Bid>> observersBids) {

        return playerBids.stream().
                flatMap(Optional::stream).
                max(Comparator.comparingInt(Bid::getAmount))
                .or(() ->
                        observersBids.stream()
                                .flatMap(Optional::stream)
                                .max(Comparator.comparingInt(Bid::getAmount))
                );

    }
}
