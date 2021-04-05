package com.example.lesson_511.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_511.R;
import com.example.lesson_511.domain.Card;
import com.example.lesson_511.ui.EmojiGame;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {
    private final EmojiGame emojiGame;
    private final Listener listener;

    public EmojiAdapter(EmojiGame emojiGame, Listener listener) {
        this.listener = listener;
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cards, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class EmojiHolder extends RecyclerView.ViewHolder {
        private TextView tvCard;

        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void onBind(Card<String> card) {
            if (card.isOsFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }
            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                listener.onCardClick();
            });
        }
    }

    public interface Listener {
        void onCardClick();
    }
}