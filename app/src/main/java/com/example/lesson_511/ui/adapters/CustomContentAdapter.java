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
import com.example.lesson_511.domain.CustomContent;
import com.example.lesson_511.ui.CustomContentGame;

public class CustomContentAdapter extends RecyclerView.Adapter<CustomContentAdapter.ContentHolder> {
    private final CustomContentGame contentGame;
    private final Listener listener;

    public CustomContentAdapter(Listener listener, CustomContentGame contentGame) {
        this.listener = listener;
        this.contentGame = contentGame;
    }

    @NonNull
    @Override
    public CustomContentAdapter.ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cards, parent, false);
        return new CustomContentAdapter.ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, int position) {
        holder.onBind(contentGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return contentGame.getCards().size();
    }

    public class ContentHolder extends RecyclerView.ViewHolder {
        private TextView tvCard;

        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void onBind(Card<CustomContent> card) {
            if (card.isOsFaceUp()) {
                tvCard.setText(card.getContent().getName());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }
            itemView.setOnClickListener(v -> {
                contentGame.choose(card);
                listener.onCardClick();
            });
        }
    }

    public interface Listener {
        void onCardClick();
    }
}