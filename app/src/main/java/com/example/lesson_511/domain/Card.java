package com.example.lesson_511.domain;

import java.util.Objects;

public class Card<Content> {
    private int id;
    private boolean isMatch;
    private boolean osFaceUp;
    private Content content;

    public Card(int id, boolean isMatch, boolean osFaceUp, Content content) {
        this.id = id;
        this.isMatch = isMatch;
        this.osFaceUp = osFaceUp;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isMatch, osFaceUp, content);
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", isMatch=" + isMatch + ", osFaceUp=" + osFaceUp + ", content=" + content + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public boolean isOsFaceUp() {
        return osFaceUp;
    }

    public void setOsFaceUp(boolean osFaceUp) {
        this.osFaceUp = osFaceUp;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}