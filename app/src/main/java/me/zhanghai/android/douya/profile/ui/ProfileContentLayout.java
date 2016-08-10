/*
 * Copyright (c) 2016 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import butterknife.BindDimen;
import butterknife.ButterKnife;
import me.zhanghai.android.douya.R;
import me.zhanghai.android.douya.ui.FlexibleSpaceContentLayout;
import me.zhanghai.android.douya.util.ViewUtils;

public class ProfileContentLayout extends FlexibleSpaceContentLayout {

    @BindDimen(R.dimen.screen_edge_horizontal_margin)
    int mScreenEdgeHorizontalMargin;
    @BindDimen(R.dimen.single_line_list_item_height)
    int mSingleLineListItemHeight;
    @BindDimen(R.dimen.card_vertical_margin)
    int mCardVerticalMargin;
    @BindDimen(R.dimen.card_shadow_vertical_margin)
    int mCardShadowVerticalMargin;
    @BindDimen(R.dimen.horizontal_divider_height)
    int mHorizontalDividerHeight;

    private boolean mInLandscape;

    public ProfileContentLayout(Context context) {
        super(context);
        init();
    }

    public ProfileContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ProfileContentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public ProfileContentLayout(Context context, AttributeSet attrs, int defStyleAttr,
                                int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init() {

        ButterKnife.bind(this);

        mInLandscape = ViewUtils.isInLandscape(getContext());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (mInLandscape) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int paddingLeft = width * 2 / 5 - mScreenEdgeHorizontalMargin;
            setPadding(paddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            int height = MeasureSpec.getSize(heightMeasureSpec);
            View contentView = getContentView();
            int contentPaddingTop = height / 2 - mSingleLineListItemHeight
                    - (mCardVerticalMargin - mCardShadowVerticalMargin) - mHorizontalDividerHeight;
            contentView.setPadding(contentView.getPaddingLeft(), contentPaddingTop,
                    contentView.getPaddingRight(), contentView.getPaddingBottom());
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}