package com.example.wan_android.newitem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wan_android.R;
import com.example.wan_android.databinding.NewsFooterItemBinding;
import com.example.wan_android.databinding.NewsItemBinding;
import com.example.wan_android.newitem.newsbean.Items;

public class NewsAdapter extends ListAdapter<Items, RecyclerView.ViewHolder> {

    public static final int NEWS_NORMAL_ITEM = 0;
    public static final int NEWS_FOOTER_ITEM = 1;
    private NewsViewModel viewModel;
    protected NewsAdapter(NewsViewModel viewModel) {
        super(new ItemCallBack());
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Log.d("NewsAdapter", "onCreateViewHolder");
        if (viewType == NEWS_NORMAL_ITEM){
            NewsItemBinding binding = NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new MyViewHolder(binding);
        }else{
            NewsFooterItemBinding binding = NewsFooterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new MyViewHolder2(binding);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() -1){
            return NEWS_FOOTER_ITEM;
        }else {
            return NEWS_NORMAL_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        Log.d("NewsAdapter", "onBindViewHolder");
        if (holder.getItemViewType() == NEWS_NORMAL_ITEM){
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.binding.txtTitle.setText(getItem(position).getTitle());
            myViewHolder.binding.txtTime.setText(getItem(position).getNiceDate());
            myViewHolder.binding.txtAuthor.setText(getItem(position).getChapterName());
            Log.e("Recycle", getItem(position).getTitle());
            myViewHolder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getItem(position).getLink()));
                view.getContext().startActivity(intent);
            });
        }else {
            MyViewHolder2 myViewHolder2 = (MyViewHolder2) holder;
            myViewHolder2.binding.txtLodingResult.setText(R.string.loading);
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private NewsItemBinding binding;
        public MyViewHolder(@NonNull NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        private NewsFooterItemBinding binding;

        public MyViewHolder2(NewsFooterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class ItemCallBack extends DiffUtil.ItemCallback<Items> {

        @Override
        public boolean areItemsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem == newItem;
        }
    }
}
