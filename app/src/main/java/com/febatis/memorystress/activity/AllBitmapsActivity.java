package com.febatis.memorystress.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.febatis.memorystress.enumeration.BitmapSize;
import com.febatis.memorystress.model.ModelSample;
import com.febatis.memorystress.util.BitmapUtil;
import com.febatis.memorystress.R;

public class AllBitmapsActivity extends AppCompatActivity {

    private ModelSample modelSample;
    private int qtdBitmaps;
    private int index;

    LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bitmaps);

        setupActivityAttributes();
        setupView();

        setupNavigation();

    }

    private void setupNavigation() {
        Button btn_avancar = findViewById(R.id.btn_avancar);
        Button btn_voltar = findViewById(R.id.btn_voltar);

        btn_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < content.getChildCount() - 1) {
                    content.getChildAt(index).setVisibility(View.GONE);
                    index++;
                    content.getChildAt(index).setVisibility(View.VISIBLE);
                }
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index != 0) {
                    content.getChildAt(index).setVisibility(View.GONE);
                    index--;
                    content.getChildAt(index).setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void setupView() {

        index = 0;

        content = findViewById(R.id.content);

        for (int i = 0; i < qtdBitmaps; i++) {

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView textView = new TextView(this);

            textView.setText("Step: " + i);

            ImageView imageView = new ImageView(this);

            imageView.setImageBitmap(
                    BitmapUtil.decodeSampledBitmapFromResource(
                            getResources(), modelSample.getResId(), 100, 100
                    )
            );

            linearLayout.addView(textView);
            linearLayout.addView(imageView);

            if (i > 0) {
                linearLayout.setVisibility(View.GONE);
            }

            content.addView(linearLayout);

        }
    }

    void setupActivityAttributes() {

        String qtdBitmapsStr = getIntent().getStringExtra(MainActivity.QTD_BITMAPS);
        qtdBitmaps = Integer.parseInt(qtdBitmapsStr);

        BitmapSize sizeBitmaps = (BitmapSize) getIntent().getSerializableExtra(MainActivity.BITMAPS_SIZE);

        modelSample = new ModelSample(0, sizeBitmaps);

    }
}
