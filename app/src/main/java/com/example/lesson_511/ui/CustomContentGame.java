package com.example.lesson_511.ui;

import android.content.Context;
import android.widget.Toast;

import com.example.lesson_511.domain.Card;
import com.example.lesson_511.domain.CustomContent;
import com.example.lesson_511.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class CustomContentGame {
    private final Game<CustomContent> game;
    private final Context context;

    public CustomContentGame(Context context) {
        this.context = context;
        List<CustomContent> contents = new ArrayList<>();
        contents.add(new CustomContent(1, "card1", 15));
        contents.add(new CustomContent(2, "card2", 14));
        contents.add(new CustomContent(3, "card3", 13));
        game = new Game<>(contents);
    }

    public void choose(Card<CustomContent> card) {
        game.choose(card);
        if (game.isEnd()) {
            finish();
        }
    }

    private void finish() {
        Toast.makeText(context, "GAME IS FINISHED!", Toast.LENGTH_SHORT).show();
    }

    public List<Card<CustomContent>> getCards() {
        return game.getCards();
    }
}
