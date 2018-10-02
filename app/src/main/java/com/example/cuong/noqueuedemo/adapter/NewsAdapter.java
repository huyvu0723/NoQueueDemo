package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<News> mNewsList;
    private Context mContext;

    public NewsAdapter(List<News> mNewsList, Context mContext) {
        this.mNewsList = mNewsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if(news.getmNewsImage() == null){
//            holder.mImgNews.setImageResource(R.mipmap.ic_no_news);
//        }else{
//            Picasso.get()
//                    .load(news.getmNewsImage())
//                    .placeholder(R.mipmap.ic_no_news)
//                    .error(R.mipmap.ic_no_news)
//                    .into(holder.mImgNews);
//        }
        News news = mNewsList.get(position);
        holder.mImgNews.setImageResource(news.getmNewsImage());
        holder.mTxtNews.setText(news.getmNewsTitle());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgNews;
        public TextView mTxtNews;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgNews = itemView.findViewById(R.id.image_view_news);
            mTxtNews = itemView.findViewById(R.id.text_view_news);
        }
    }
}
