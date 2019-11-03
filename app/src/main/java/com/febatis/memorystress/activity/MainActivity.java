package com.febatis.memorystress.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.febatis.memorystress.R;
import com.febatis.memorystress.enumeration.BitmapSize;

public class MainActivity extends AppCompatActivity {

    static String QTD_BITMAPS = "QTD_BITMAPS";
    static String BITMAPS_SIZE = "BITMAPS_SIZE";

    Spinner spinner_image_size;
    EditText et_bitmapQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupEditText();
        setupButtons();
        setupSpinner();

    }

    private void setupEditText() {
        et_bitmapQtd = findViewById(R.id.et_bitmapQtd);
        et_bitmapQtd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(et_bitmapQtd.getText().toString().isEmpty()) {
                    et_bitmapQtd.setText("0");
                    return;
                }

                int intValue = Integer.parseInt(et_bitmapQtd.getText().toString());

                if (intValue < 0) {
                    et_bitmapQtd.setText("0");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void setupSpinner() {

        String[] array_spinner;

        array_spinner = new String[3];
        array_spinner[0] = "720p";
        array_spinner[1] = "1080p";
        array_spinner[2] = "6000 X 3000";

        spinner_image_size = findViewById(R.id.spinner_image_size);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array_spinner);
        spinner_image_size.setAdapter(adapter);
    }

    private void setupButtons() {
        Button openAllBitmaps = findViewById(R.id.openAllBitmaps);
        Button openBitmapsInFragments = findViewById(R.id.openBitmapsInFragments);

        openAllBitmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(AllBitmapsActivity.class);
            }
        });

        openBitmapsInFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(BitmapsInFragmentsActivity.class);
            }
        });

    }

    void openActivity(Class classe) {
        Intent intent = new Intent(getApplicationContext(), classe);


        intent.putExtra(QTD_BITMAPS,  et_bitmapQtd.getText().toString());

        BitmapSize bitmapSize = BitmapSize.valueByDescription(spinner_image_size.getSelectedItem().toString());

        intent.putExtra(BITMAPS_SIZE, bitmapSize);

        startActivity(intent);
    }


}
