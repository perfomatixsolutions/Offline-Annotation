package com.android.videoannotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DrawableView extends android.view.View{


    private Paint mPaintLocal;
    private Paint mPaintRemote;
    private Path mPathLocal = new Path();
    private Path mPathRemote = new Path();
    private boolean mNewLineKeeper = true;
    private boolean mDrawEnable = false;
    public static final int DRAWLINE_WIDTH = 5;
    public static final int SETCOLOR = Color.BLUE;


    public DrawableView(Context context) {
        super(context);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init()
    {
        setupPaint(DRAWLINE_WIDTH,SETCOLOR);
    }

    public void setupPaint(float strokewidth,int setColor) {
        mPaintLocal = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLocal.setColor(setColor);
        mPaintLocal.setAntiAlias(true);
        mPaintLocal.setStrokeWidth(strokewidth);
        mPaintLocal.setStyle(Paint.Style.STROKE);
        mPaintLocal.setStrokeJoin(Paint.Join.ROUND);
        mPaintLocal.setStrokeCap(Paint.Cap.ROUND);

        mPaintRemote = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintRemote.setColor(setColor);
        mPaintRemote.setAntiAlias(true);
        mPaintRemote.setStrokeWidth(strokewidth);
        mPaintRemote.setStyle(Paint.Style.STROKE);
        mPaintRemote.setStrokeJoin(Paint.Join.ROUND);
        mPaintRemote.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (mDrawEnable) {
                canvas.drawPath(mPathLocal, new Paint(mPaintLocal));
                canvas.drawPath(mPathRemote, new Paint(mPaintRemote));
            }
        } catch (Exception e) {

        }
    }

    public void setDrawEnable(boolean drawEnable) {
        mDrawEnable = drawEnable;
        clearDrawRemote();
        clearDrawLocal();
    }

    public void updateXY(float x, float y, boolean isNewLine) {
        if(isNewLine == false && mNewLineKeeper == true)
        {
            isNewLine = true;
        }
        if (isNewLine) {
            mPathRemote.moveTo(x, y);
            mNewLineKeeper = false;
        } else {
            mPathRemote.lineTo(x, y);
        }
        invalidate();
    }

    public void clearDrawLocal() {
        mNewLineKeeper = true;
        mPathLocal = new Path();
        invalidate();
    }

    public void clearDrawRemote() {
        mNewLineKeeper = true;
        mPathRemote = new Path();
        invalidate();
    }

    public void remoteNextNewLine() {
        mNewLineKeeper = true;
    }

    // Get x and y and append them to the path
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        // Checks for the event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                mPathLocal.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Draws line between last point and this point
                mPathLocal.lineTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_UP:
                mPathLocal.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }

        invalidate(); // Indicate view should be redrawn
        return true; // Indicate we've consumed the touch
    }

}
