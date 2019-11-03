package com.febatis.memorystress.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.febatis.memorystress.fragment.StepFragment;
import com.febatis.memorystress.model.ModelSample;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    List<ModelSample> modelSampleList;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<ModelSample> modelSampleList) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.modelSampleList = modelSampleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return new StepFragment(modelSampleList.get(i));
    }

    @Override
    public int getCount() {
        return modelSampleList.size();
    }
}
