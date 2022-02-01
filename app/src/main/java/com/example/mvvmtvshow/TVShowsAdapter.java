package com.example.mvvmtvshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtvshow.databinding.ItemContainerTvShowBinding;
import com.example.mvvmtvshow.listeners.TVShowsListener;
import com.example.mvvmtvshow.models.TVShow;

import java.util.List;

public class TVShowsAdapter  extends RecyclerView.Adapter<TVShowsAdapter.TVShowViewHolder>{

    private final List<TVShow> tvShows;
    private LayoutInflater layoutInflater;
    private final TVShowsListener tvShowsListener;

    public TVShowsAdapter(List<TVShow> tvShows, TVShowsListener tvShowsListener) {
        this.tvShows = tvShows;
        this.tvShowsListener = tvShowsListener;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = DataBindingUtil.inflate(
                layoutInflater,R.layout.item_container_tv_show,parent,false
        );
        return new TVShowViewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        holder.bindTVShow(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class TVShowViewHolder extends RecyclerView.ViewHolder{

        private final ItemContainerTvShowBinding itemContainerTvShowBinding;
      public TVShowViewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding) {
          super(itemContainerTvShowBinding.getRoot());
          this.itemContainerTvShowBinding = itemContainerTvShowBinding;
      }

      public void bindTVShow(TVShow tvShow){
          itemContainerTvShowBinding.setTvShow(tvShow);
          itemContainerTvShowBinding.executePendingBindings();
          itemContainerTvShowBinding.getRoot().setOnClickListener(view -> tvShowsListener.onTVShowClicked(tvShow));
      }
  }
}
