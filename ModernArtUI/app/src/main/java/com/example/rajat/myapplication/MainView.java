package com.example.rajat.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MainView extends View {

    String TAG = "mask_color";

    Paint paint;
    int maskColor;
    int rightMargin;
    int leftMargin;
    int fiveDpMargin;
    int oneEightyDpMargin;
    int oneNinetyDpMargin;
    int threeSeventyDpMargin;
    int threeEightyDpMargin;

    public MainView(Context context) {
        super(context);
        init();
    }

    public MainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        paint = new Paint();
        maskColor = Color.argb(0,0,0,0);

        Resources resources = getContext().getResources();
        rightMargin = resources.getDimensionPixelSize(R.dimen.right_margin);
        leftMargin = resources.getDimensionPixelSize(R.dimen.left_margin);
        fiveDpMargin = resources.getDimensionPixelSize(R.dimen.five_dp_margin);
        oneEightyDpMargin = resources.getDimensionPixelSize(R.dimen.one_eighty_dp_margin);
        oneNinetyDpMargin = resources.getDimensionPixelSize(R.dimen.one_ninety_dp_margin);
        threeSeventyDpMargin = resources.getDimensionPixelSize(R.dimen.three_seventy_dp_margin);
        threeEightyDpMargin = resources.getDimensionPixelSize(R.dimen.three_eighty_dp_margin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, canvas.getWidth() / 2 - rightMargin, canvas.getHeight() / 2 - fiveDpMargin, paint);

        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, canvas.getHeight() / 2 + fiveDpMargin, canvas.getWidth() / 2 - rightMargin, canvas.getHeight(), paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(canvas.getWidth() / 2 - leftMargin, 0, canvas.getWidth(), oneEightyDpMargin, paint);

        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(canvas.getWidth() / 2 - leftMargin, oneNinetyDpMargin, canvas.getWidth(), threeSeventyDpMargin, paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(canvas.getWidth() / 2 - leftMargin, threeEightyDpMargin, canvas.getWidth(), canvas.getHeight(), paint);

        Log.d(TAG, "Value:" + Integer.toString(maskColor));

        paint.setColor(maskColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, canvas.getWidth() / 2 - rightMargin, canvas.getHeight() / 2 - fiveDpMargin, paint);
        canvas.drawRect(0, canvas.getHeight() / 2 + fiveDpMargin, canvas.getWidth() / 2 - rightMargin, canvas.getHeight(), paint);
        canvas.drawRect(canvas.getWidth() / 2 - leftMargin, 0, canvas.getWidth(), oneEightyDpMargin, paint);
        canvas.drawRect(canvas.getWidth() / 2 - leftMargin, threeEightyDpMargin, canvas.getWidth(), canvas.getHeight(), paint);
    }

    public void updateMaskColor(int color) {
        maskColor = color;
        invalidate();
        requestLayout();
    }

}
