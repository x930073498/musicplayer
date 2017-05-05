package com.x930073498.MusicPlayer.screen.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.screen.viewModel.MainViewModel;
import com.x930073498.androidLib.RxResultActivity.RxResult;
import com.x930073498.core.mvvm.BaseActivity;
import com.x930073498.musicplayer.R;
import com.x930073498.musicplayer.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBinding.setVM(ViewModel);
    }

    @Override
    protected boolean useAndroidInject() {
        return true;
    }

    @Override
    public void showMessage(int message) {
        toast(message);
    }

    @Override
    public void handStartActivity() {
        RxResult.of(String.class).activity(SecondActivity.class).requestCode(1000).key("data").start(this).compose(this.bindUntilEvent(ActivityEvent.DESTROY)).subscribe(this::toast);
    }

}