package com.danmaku.rndanmaku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.danmaku.rndanmaku.danmu.DanmuControl;
import com.danmaku.rndanmaku.model.Danmu;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.ui.widget.DanmakuView;

public class DanmakuViewManager extends SimpleViewManager<DanmakuView> implements LifecycleEventListener {

    public static final String REACT_CLASS = "RCTDanmaku";

    private RCTEventEmitter mEventEmitter;
    private ThemedReactContext reactContext;
    private DanmakuView mDanmakuView;
    private DanmuControl mDanmuControl;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected DanmakuView createViewInstance(ThemedReactContext reactContext) {
        this.reactContext = reactContext;
        mEventEmitter = reactContext.getJSModule(RCTEventEmitter.class);
        mDanmuControl = new DanmuControl(reactContext);
        mDanmakuView = new DanmakuView(reactContext);
        mDanmuControl.setDanmakuView(mDanmakuView);

        reactContext.addLifecycleEventListener(this);
        setData();
        return mDanmakuView;
    }

    private void setData() {
        List<Danmu> danmus = new ArrayList<>();
        Danmu danmu1 = new Danmu(0, 1, "Like", R.mipmap.ic_default_header, "");
        Danmu danmu2 = new Danmu(0, 2, "Comment", R.mipmap.ic_default_header, "这是一条弹幕啦啦啦");
        Danmu danmu3 = new Danmu(0, 3, "Like", R.mipmap.ic_default_header, "");
        danmus.add(danmu1);
        danmus.add(danmu2);
        danmus.add(danmu3);
        Collections.shuffle(danmus);
        mDanmuControl.addDanmuList(danmus);
    }

    @Override
    public void onHostResume() {
        mDanmuControl.resume();
    }

    @Override
    public void onHostPause() {
        mDanmuControl.pause();
    }

    @Override
    public void onHostDestroy() {
        mDanmuControl.destroy();
    }
}
