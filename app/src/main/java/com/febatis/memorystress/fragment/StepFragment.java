package com.febatis.memorystress.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.febatis.memorystress.R;
import com.febatis.memorystress.model.ModelSample;
import com.febatis.memorystress.util.BitmapUtil;

public class StepFragment extends Fragment {

    private ModelSample modelSample;

    public StepFragment(ModelSample modelSample) {
        this.modelSample = modelSample;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bitmap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView tv_position = view.findViewById(R.id.tv_position);

        tv_position.setText("Step: " + modelSample.getPosition());

        LinearLayout content = view.findViewById(R.id.fragment_content);

        ImageView imageView = new ImageView(getContext());

        imageView.setImageBitmap(
                BitmapUtil.decodeSampledBitmapFromResource(
                        getResources(), modelSample.getResId(), 100, 100
                )
        );

        content.addView(imageView);

    }
}
