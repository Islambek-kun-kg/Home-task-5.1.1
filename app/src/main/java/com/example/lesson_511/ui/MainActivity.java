package com.example.lesson_511.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lesson_511.R;
import com.example.lesson_511.domain.CustomContent;
import com.example.lesson_511.ui.adapters.CustomContentAdapter;
import com.example.lesson_511.ui.adapters.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener, CustomContentAdapter.Listener {
    private RecyclerView recyclerView;
    private CustomContentGame contentGame;
    //    private EmojiGame emojiGame;
    //    private EmojiAdapter adapter;
    private CustomContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentGame = new CustomContentGame(this);
        adapter = new CustomContentAdapter(this, contentGame);
        recyclerView = findViewById(R.id.rv_cards);
        recyclerView.setAdapter(adapter);

        CustomContent content = new CustomContent(1, "card1", 12);
        CustomContent content1 = new CustomContent(1, "card1", 12);
        Log.d("tag", String.valueOf(content.equals(content1)));
    }

    @Override
    public void onCardClick() {
        adapter.notifyDataSetChanged();
    }
}