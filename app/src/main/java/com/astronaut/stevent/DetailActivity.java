package com.astronaut.stevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

//    private ImageView imageView;
//    private TextView tvName, tvDate, tvLocation, tvDetail;


    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_LOCATION = "extra_location";
    public static final String EXTRA_DETAIL = "extra_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_item_photo);
        TextView tvName = findViewById(R.id.tv_item_name);
        TextView tvDate = findViewById(R.id.tv_item_date);
        TextView tvLocation = findViewById(R.id.tv_item_location);
        TextView tvDetail = findViewById(R.id.tv_item_detail);

        int image = getIntent().getIntExtra(EXTRA_IMAGE,0);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String date = getIntent().getStringExtra(EXTRA_DATE);
        String location = getIntent().getStringExtra(EXTRA_LOCATION);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);

        imageView.setImageResource(image);
        tvName.setText(name);
        tvDate.setText(date);
        tvLocation.setText(location);
        tvDetail.setText(detail);


    }
}
