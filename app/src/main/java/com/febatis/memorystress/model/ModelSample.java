package com.febatis.memorystress.model;

import com.febatis.memorystress.R;
import com.febatis.memorystress.enumeration.BitmapSize;

public class ModelSample {

    private int position;
    private int resId;

    public ModelSample(int position, int resId) {
        this.position = position;
        this.resId = resId;
    }

    public ModelSample(int position, BitmapSize resId) {
        this.position = position;
        this.resId = getResIdByEnum(resId);
    }

    private int getResIdByEnum(BitmapSize resId) {
        switch (resId) {
            case RESOLUTION_720P:
                return R.drawable.bitmap_720p;
            case RESOLUTION_1080P:
                return R.drawable.bitmap_1080p;
            case RESOLUTION_6000X3000:
                return R.drawable.bitmap_6000x3000;
        }

        return 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
