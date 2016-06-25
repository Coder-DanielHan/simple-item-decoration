package com.dgreenhalgh.android.simpleitemdecorationsample.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.dgreenhalgh.android.simpleitemdecoration.linear.EndOffsetItemDecoration;
import com.dgreenhalgh.android.simpleitemdecoration.linear.StartOffsetItemDecoration;
import com.dgreenhalgh.android.simpleitemdecorationsample.R;
import com.dgreenhalgh.android.simpleitemdecorationsample.two.SampleDataBank;
import com.dgreenhalgh.android.simpleitemdecorationsample.two.SimpleItemDecorationSampleListAdapter;
import com.dgreenhalgh.android.simpleitemdecorationsample.view.ControlView;

import java.util.List;


public class VerticalLinearLayoutManagerSampleActivity extends ActionBarActivity {

    private ControlView mControlView;
    private RecyclerView mRecyclerView;
    private RecyclerView.ItemDecoration mDividerItemDecoration;
    private RecyclerView.ItemDecoration mStartOffsetItemDecoration;
    private RecyclerView.ItemDecoration mStartDrawableOffsetItemDecoration;
    private RecyclerView.ItemDecoration mEndOffsetItemDecoration;
    private RecyclerView.ItemDecoration mEndDrawableOffsetItemDecoration;

    private boolean mDividersVisible;
    private boolean mStartOffsetVisible;
    private boolean mStartDrawableOffsetVisible;
    private boolean mEndOffsetVisible;
    private boolean mEndDrawableOffsetVisible;

    public static Intent newIntent(Context context) {
        return new Intent(context, VerticalLinearLayoutManagerSampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_linear_layout_manager_sample);

        mControlView = (ControlView) findViewById(R.id.activity_vertical_linear_layout_manager_sample_dividerControlsView);
        mControlView.setItemDecorationVisibilityChangeListener(mItemDecorationVisibilityChangeListener);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initRecyclerView();
    }

    private void initRecyclerView() {
        List<String> sampleStringList = SampleDataBank.getSampleData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SimpleItemDecorationSampleListAdapter(sampleStringList));

        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_sample);
        mDividerItemDecoration = new DividerItemDecoration(dividerDrawable);

        Resources resources = getResources();
//        int startOffsetPx = resources.getDimensionPixelOffset(R.dimen.start_offset);
//        mStartOffsetItemDecoration = new StartOffsetItemDecoration(startOffsetPx);

        mStartDrawableOffsetItemDecoration = new StartOffsetItemDecoration(dividerDrawable);

//        int endOffsetPx = resources.getDimensionPixelOffset(R.dimen.end_offset);
//        mEndOffsetItemDecoration = new EndOffsetItemDecoration(endOffsetPx);

        mEndDrawableOffsetItemDecoration = new EndOffsetItemDecoration(dividerDrawable);
    }

    private void toggleDividerVisibility() {
        if (mDividersVisible) {
            mRecyclerView.removeItemDecoration(mDividerItemDecoration);
            mDividersVisible = false;
        } else {
            mRecyclerView.addItemDecoration(mDividerItemDecoration);
            mDividersVisible = true;
        }
    }

    private void toggleStartOffsetVisibility() {
        if (mStartOffsetVisible) {
            mRecyclerView.removeItemDecoration(mStartOffsetItemDecoration);
            mStartOffsetVisible = false;
        } else {
            mRecyclerView.addItemDecoration(mStartOffsetItemDecoration);
            mStartOffsetVisible = true;
        }
    }

    private void toggleStartDrawableOffsetVisibility() {
        if (mStartDrawableOffsetVisible) {
            mRecyclerView.removeItemDecoration(mStartDrawableOffsetItemDecoration);
            mStartDrawableOffsetVisible = false;
        } else {
            mRecyclerView.addItemDecoration(mStartDrawableOffsetItemDecoration);
            mStartDrawableOffsetVisible = true;
        }
    }

    private void toggleEndOffsetVisibility() {
        if (mEndOffsetVisible) {
            mRecyclerView.removeItemDecoration(mEndOffsetItemDecoration);
            mEndOffsetVisible = false;
        } else {
            mRecyclerView.addItemDecoration(mEndOffsetItemDecoration);
            mEndOffsetVisible = true;
        }
    }

    private void toggleEndDrawableOffsetVisibility() {
        if (mEndDrawableOffsetVisible) {
            mRecyclerView.removeItemDecoration(mEndDrawableOffsetItemDecoration);
            mEndDrawableOffsetVisible = false;
        } else {
            mRecyclerView.addItemDecoration(mEndDrawableOffsetItemDecoration);
            mEndDrawableOffsetVisible = true;
        }
    }

    private ControlView.ItemDecorationVisibilityChangeListener mItemDecorationVisibilityChangeListener = new ControlView.ItemDecorationVisibilityChangeListener() {
        @Override
        public void onDividerVisibilityChange() {
            toggleDividerVisibility();
        }

        @Override
        public void onStartOffsetVisibilityChange() {
            toggleStartOffsetVisibility();
        }

//        @Override
//        public void onStartDrawableOffsetVisibilityChange() {
//            toggleStartDrawableOffsetVisibility();
//        }

        @Override
        public void onEndOffsetVisibilityChange() {
            toggleEndOffsetVisibility();
        }

//        @Override
//        public void onEndDrawableOffsetVisibilityChange() {
//            toggleEndDrawableOffsetVisibility();
//        }
    };
}
