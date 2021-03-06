package com.x930073498.MusicPlayer.dependencies.module;


import com.x930073498.MusicPlayer.screen.activity.MainActivity;
import com.x930073498.MusicPlayer.screen.model.MainModel;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.screen.viewModel.MainViewModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    @Provides
    MainView mainView(MainActivity activity) {
        return activity;
    }

    @Provides
    MainModel mainModel() {
        MainModel model = new MainModel("测试");
        model.setStartAction("跳转");
        return model;
    }

    @Provides
    MainViewModel mainViewModel(MainActivity activity, MainModel model) {
        return new MainViewModel(activity, model, activity);
    }


}
