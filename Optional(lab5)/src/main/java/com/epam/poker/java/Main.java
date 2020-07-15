package com.epam.poker.java;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<Optional<Bid>> playerBids = List.of(
                Optional.of(Bid.builder().amount(300).bidder("Alex").build()),
                Optional.of(Bid.builder().amount(1200).bidder("Alex1").build()),
                Optional.empty(),
                Optional.of(Bid.builder().bidder("Alex3").build()),
                Optional.of(Bid.builder().amount(600).bidder("Alex4").build()),
                Optional.empty(),
                Optional.of(Bid.builder().bidder("Alex6").build())
        );

        List<Optional<Bid>> observerBids = List.of(
                Optional.of(Bid.builder().amount(300).bidder("John").build()),
                Optional.of(Bid.builder().amount(1200).bidder("John1").build()),
                Optional.empty(),
                Optional.empty()
        );

        List<Optional<Bid>> emptyOptionals = List.of(
                Optional.empty(),
                Optional.empty()
        );


        PokerService.getWinner(playerBids, observerBids)
                .ifPresentOrElse(
                        bidder -> System.out.println("The bidder " + bidder.getBidder() + " Won!"),
                        () -> System.out.println("The was no bidders")
                );

        PokerService.getWinner(emptyOptionals, observerBids)
                .ifPresentOrElse(
                        bidder -> System.out.println("The bidder " + bidder.getBidder() + " Won!"),
                        () -> System.out.println("The was no bidders")
                );

        PokerService.getWinner(emptyOptionals, emptyOptionals)
                .ifPresentOrElse(
                        bidder -> System.out.println("The bidder " + bidder.getBidder() + " Won!"),
                        () -> System.out.println("The was no bidders")
                );

    }
}
