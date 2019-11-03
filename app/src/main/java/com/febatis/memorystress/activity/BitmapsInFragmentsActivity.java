package com.febatis.memorystress.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.febatis.memorystress.R;
import com.febatis.memorystress.adapter.ScreenSlidePagerAdapter;
import com.febatis.memorystress.enumeration.BitmapSize;
import com.febatis.memorystress.model.ModelSample;

import java.util.ArrayList;
import java.util.List;

public class BitmapsInFragmentsActivity extends AppCompatActivity {

    private BitmapSize sizeBitmaps;
    private int qtdBitmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmaps_in_fragments);

        setupActivityAttribute();

        List<ModelSample> modelSampleList = generateMockData(qtdBitmaps, sizeBitmaps);

        setupViewPager(modelSampleList);
    }

    private void setupViewPager(List<ModelSample> modelSampleList) {
        ViewPager mPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), modelSampleList);
        mPager.setAdapter(pagerAdapter);
    }

    private void setupActivityAttribute() {
        String qtdBitmapsStr = getIntent().getStringExtra(MainActivity.QTD_BITMAPS);
        qtdBitmaps = Integer.parseInt(qtdBitmapsStr);

        sizeBitmaps = (BitmapSize) getIntent().getSerializableExtra(MainActivity.BITMAPS_SIZE);
    }

    private List<ModelSample> generateMockData(int qtdBitmaps, BitmapSize sizeBitmaps) {
        List<ModelSample> modelSampleList = new ArrayList<>();

        for (int i = 0; i < qtdBitmaps; i++) {
            modelSampleList.add(new ModelSample(i, sizeBitmaps));
        }

        return modelSampleList;
    }
}