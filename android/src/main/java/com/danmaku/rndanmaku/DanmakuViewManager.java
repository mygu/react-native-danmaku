package com.danmaku.rndanmaku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.danmaku.rndanmaku.controller.DanmakuController;
import com.danmaku.rndanmaku.model.Danmaku;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import master.flame.danmaku.ui.widget.DanmakuView;

/**
 * Created by mygu on 16/6/20.
 */
public class DanmakuViewManager extends SimpleViewManager<DanmakuView> implements LifecycleEventListener {

    public static final String REACT_CLASS = "RCTDanmaku";

    private RCTEventEmitter mEventEmitter;
    private ThemedReactContext reactContext;
    private DanmakuView mDanmakuView;
    private DanmakuController mDanmakuController;
    private boolean started;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected DanmakuView createViewInstance(ThemedReactContext reactContext) {
        this.reactContext = reactContext;
        mEventEmitter = reactContext.getJSModule(RCTEventEmitter.class);
        mDanmakuController = new DanmakuController(reactContext);
        mDanmakuView = new DanmakuView(reactContext);
        mDanmakuController.setDanmakuView(mDanmakuView);

        reactContext.addLifecycleEventListener(this);

        return mDanmakuView;
    }

    @ReactProp(name = "started")
    public void setStarted(DanmakuView mDanmakuView, boolean started) {
        this.started = started;
        if (started) {
            setData();
        }
    }

    private void setData() {
        List<Danmaku> danmakus = new ArrayList<>();
        Danmaku danmaku1 = new Danmaku(0, 1, "Like", R.mipmap.ic_default_header, "");
        Danmaku danmaku2 = new Danmaku(0, 2, "Comment", R.mipmap.ic_default_header, "这是一条弹幕啦啦啦");
        Danmaku danmaku3 = new Danmaku(0, 3, "Like", R.mipmap.ic_default_header, "");
        Danmaku danmaku4 = new Danmaku(0, 1, "Comment", R.mipmap.ic_default_header, "这又是一条弹幕啦啦啦");
        Danmaku danmaku5 = new Danmaku(0, 2, "Like", R.mipmap.ic_default_header, "");
        Danmaku danmaku6 = new Danmaku(0, 3, "Comment", R.mipmap.ic_default_header, "这还是一条弹幕啦啦啦");

        danmakus.add(danmaku1);
        danmakus.add(danmaku2);
        danmakus.add(danmaku3);
        danmakus.add(danmaku4);
        danmakus.add(danmaku5);
        danmakus.add(danmaku6);
        Collections.shuffle(danmakus);
        mDanmakuController.addDanmuList(danmakus);
    }

    @Override
    public void onHostResume() {
        mDanmakuController.resume();
    }

    @Override
    public void onHostPause() {
        mDanmakuController.pause();
    }

    @Override
    public void onHostDestroy() {
        mDanmakuController.destroy();
    }
}
