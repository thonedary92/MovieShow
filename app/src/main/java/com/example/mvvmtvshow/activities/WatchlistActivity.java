package com.example.mvvmtvshow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmtvshow.R;
import com.example.mvvmtvshow.databinding.ActivityWatchlistBinding;
import com.example.mvvmtvshow.viewmodels.WatchlistViewModel;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class WatchlistActivity extends AppCompatActivity {
    private ActivityWatchlistBinding activityWatchlistBinding;
    private WatchlistViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityWatchlistBinding = DataBindingUtil.setContentView(this,R.layout.activity_watchlist);
        doInitialization();
    }

    private void doInitialization(){
        viewModel = new ViewModelProvider(this).get(WatchlistViewModel.class);
        activityWatchlistBinding.imageBack.setOnClickListener(view -> { onBackPressed(); });
    }

    private void loadWatchlist() {

        activityWatchlistBinding.setIsLoading(true);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(viewModel.loadWatchlist().subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tvShows -> {
                    activityWatchlistBinding.setIsLoading(false);
                    Toast.makeText(getApplicationContext()," watchList: "+ tvShows.size(),Toast.LENGTH_SHORT).show();
                }));

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadWatchlist();
    }
}