package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private LayoutInflater inflater;

    public WordListAdapter(Context context,
                           LinkedList<String> wordList) {
        inflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter listAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.listAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPostion = getLayoutPosition();
            String element = mWordList.get(mPostion);
            mWordList.set(mPostion, "Clicked! " + element);
            listAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
