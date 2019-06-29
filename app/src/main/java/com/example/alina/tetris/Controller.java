package com.example.alina.tetris;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.alina.tetris.listeners.OnPlayingAreaClick;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by Alina on 18.03.2017.
 */

public class Controller extends LinearLayout {

    private OnPlayingAreaClick onPlayingAreaClick;

    public Controller(Context context) {
        super(context);
        setLayout();
    }

    public Controller(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayout();
    }

    public Controller(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayout();
    }

    private void setLayout() {
        View view = inflate(getContext(), R.layout.left_right_controls, this);
        ButterKnife.bind(this, view);
    }

    public void setOnPlayingAreaClick(OnPlayingAreaClick onPlayingAreaClick) {
        this.onPlayingAreaClick = onPlayingAreaClick;
    }

    @OnClick(R.id.bLeft)
    void moveLeft() {
        if (onPlayingAreaClick != null) {
            onPlayingAreaClick.onLeftButtonClick();
        }
    }

    @OnClick (R.id.bRight)
    void moveRight() {
        if (onPlayingAreaClick != null) {
            onPlayingAreaClick.onRightButtonClick();
        }
    }

    @OnLongClick(R.id.bLeft)
    boolean moveLeftFast() {
        if (onPlayingAreaClick != null) {
            onPlayingAreaClick.onLeftButtonLongClick();
        }
        return true;
    }

    @OnLongClick (R.id.bRight)
    boolean moveRightFast() {
        if (onPlayingAreaClick != null) {
            onPlayingAreaClick.onRightButtonLongClick();
        }
        return true;
    }
}
