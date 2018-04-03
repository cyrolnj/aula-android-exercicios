package com.solutions.oryc.geometriccalculator;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.icu.text.NumberFormat;
import android.net.ParseException;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText txtRadius;
    TextView vtxtRadius;
    EditText txtBase;
    TextView vtxtBase;
    EditText txtHight;
    TextView vtxtHight;
    RadioButton rbSquare;
    RadioButton rbTriangle;
    RadioButton rbCircle;
    TextView vtxtResult;
    ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRadius = findViewById(R.id.txt_radius);
        vtxtRadius = findViewById(R.id.vtxt_radius);
        txtBase = findViewById(R.id.txt_base);
        vtxtBase = findViewById(R.id.vtxt_base);
        txtHight = findViewById(R.id.txt_hight);
        vtxtHight = findViewById(R.id.vtxt_hight);
        imgResult = findViewById(R.id.img_result);
        vtxtResult = findViewById(R.id.vtxt_result);


        txtRadius.setVisibility(View.GONE);
        vtxtRadius.setVisibility(View.GONE);
        txtBase.setVisibility(View.GONE);
        vtxtBase.setVisibility(View.GONE);
        txtHight.setVisibility(View.GONE);
        vtxtHight.setVisibility(View.GONE);
        imgResult.setVisibility(View.GONE);

    }

    public void onRadioButtonClicked(View view) {

        rbSquare = findViewById(R.id.rb_square_rectangle);
        rbTriangle = findViewById(R.id.rb_triangle);
        rbCircle = findViewById(R.id.rb_circle);

        if (rbSquare.isChecked() == true) {

            txtRadius.setVisibility(View.GONE);
            vtxtRadius.setVisibility(View.GONE);
            txtBase.setVisibility(View.VISIBLE);
            vtxtBase.setVisibility(View.VISIBLE);
            txtHight.setVisibility(View.VISIBLE);
            vtxtHight.setVisibility(View.VISIBLE);
        } else if (rbTriangle.isChecked() == true) {
            txtRadius.setVisibility(View.GONE);
            vtxtRadius.setVisibility(View.GONE);
            txtBase.setVisibility(View.VISIBLE);
            vtxtBase.setVisibility(View.VISIBLE);
            txtHight.setVisibility(View.VISIBLE);
            vtxtHight.setVisibility(View.VISIBLE);
        } else if (rbCircle.isChecked() == true) {
            txtBase.setVisibility(View.GONE);
            vtxtBase.setVisibility(View.GONE);
            txtHight.setVisibility(View.GONE);
            vtxtHight.setVisibility(View.GONE);
            txtRadius.setVisibility(View.VISIBLE);
            vtxtRadius.setVisibility(View.VISIBLE);
        }

        vtxtResult.setVisibility(View.GONE);
        imgResult.setVisibility(View.GONE);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onCalculateClicked(View view) {

        Double result = 0.0;
        Drawable image = null;
        Resources res = getResources();

        rbSquare = findViewById(R.id.rb_square_rectangle);
        rbTriangle = findViewById(R.id.rb_triangle);
        rbCircle = findViewById(R.id.rb_circle);
        vtxtResult = findViewById(R.id.vtxt_result);

        if (rbSquare.isChecked() == true) {

            Double base = Double.parseDouble(txtBase.getText().toString());
            Double hight = Double.parseDouble(txtHight.getText().toString());
            result = base * hight;

            vtxtResult.setText(Double.toString(result));

            if (base.equals(hight)) {
                image = res.getDrawable(R.drawable.ic_crop_square_black_48dp);
            } else {
                image = res.getDrawable(R.drawable.ic_crop_16_9_black_48dp);
            }
        } else if (rbTriangle.isChecked() == true) {

            Double base = Double.parseDouble(txtBase.getText().toString());
            Double hight = Double.parseDouble(txtHight.getText().toString());
            result = ( base * hight ) / 2;

            vtxtResult.setText(Double.toString(result));

            image = res.getDrawable(R.drawable.ic_change_history_black_48dp);
        } else if (rbCircle.isChecked() == true) {
            Double radius = Double.parseDouble(txtRadius.getText().toString());
            result = Math.PI * (radius * radius);
            image = res.getDrawable(R.drawable.ic_panorama_fish_eye_black_48dp);
        }

        vtxtResult.setText(getString(R.string.area) + " " + Double.toString(result) + ", " + getString(R.string.cm));
        //vtxtResult.setText(Double.toString(result));
        imgResult.setImageDrawable(image);
        imgResult.setVisibility(View.VISIBLE);
        vtxtResult.setVisibility(View.VISIBLE);

    }
}
