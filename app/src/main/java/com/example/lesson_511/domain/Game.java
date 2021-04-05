package com.example.lesson_511.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {
    private List<Card<Content>> cards = new ArrayList<>();
    private boolean end = false;

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setOsFaceUp(!card.isOsFaceUp());
        checkPairs(card);
        finish();
    }

    private void finish() {
        if (cards.isEmpty()) setEnd(true);
    }

    private void checkPairs(Card<Content> card) {
        for (int i = 0; i < cards.size(); i++) {
            if (card.isOsFaceUp() && cards.get(i).isOsFaceUp() && cards.get(i).getId() != card.getId() && card.equals(cards.get(i))) {
                Log.d("TAG", "TRUE CHOOSE!!!");
                card.setMatch(true);
                cards.get(i).setMatch(true);
                removeCardInYourPosition();
            } else if (card.isOsFaceUp() && cards.get(i).isOsFaceUp() && card.getId() != cards.get(i).getId() && !card.equals(cards.get(i))) {
                card.setOsFaceUp(false);
                cards.get(i).setOsFaceUp(false);
                Log.d("TAG", "WRONG CHOOSE!!!");
            }
        }
    }

    private void removeCardInYourPosition() {
        List<Card<Content>> cardArrayList = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isMatch()) cardArrayList.remove(cards.get(i));
        }
        cards.clear();
        cards.addAll(cardArrayList);
    }

    public List<Card<Content>> getCards() {
        return cards;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}