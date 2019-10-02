package com.rdi.forelessons;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();
    private final String SAVE_PARCEL = "SAVE_PARCEL";

    private TestModel testModel;
    public Button mButton;
    public TextView mTextFieldOne;
    public TextView mTextFieldTwo;
    public TextView mTextFieldListOne;
    public TextView mTextFieldListTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        setTitle(R.string.search_activity_name);
        testModel = new TestModel();
        testModel.initializationOfVariablesByRandom();
        setUI();
        filUI();
        Log.d(TAG, new StringBuilder(TAG).append("onCreate").toString());
    }

    private void setUI() {
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this::onClick);
        mTextFieldOne = findViewById(R.id.text_string_one);
        mTextFieldTwo = findViewById(R.id.text_string_two);
        mTextFieldListOne = findViewById(R.id.text_list_string_one);
        mTextFieldListTwo = findViewById(R.id.text_list_string_two);

    }

    private void filUI() {
        mTextFieldOne.setText(testModel.getFieldOne());
        mTextFieldTwo.setText(testModel.getFieldTwo());
        mTextFieldListOne.setText(testModel.getFirstList().toString());
        mTextFieldListTwo.setText(testModel.getSecondList().toString());

        Log.d(TAG, "filUI: " + testModel.getFieldOne() + " " + testModel.getFieldTwo());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(SAVE_PARCEL, testModel);
        super.onSaveInstanceState(outState);
        Log.d(TAG, new StringBuilder(TAG).append("onSaveInstanceState").toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        testModel = savedInstanceState.getParcelable(SAVE_PARCEL);
        filUI();
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, new StringBuilder(TAG).append("onRestoreInstanceState").toString());
    }


    private void onClick(View view) {
        Intent intent = new Intent(this, PersonalAccountActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Log.d(TAG, new StringBuilder(TAG).append("onClick").toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, new StringBuilder(TAG).append("onStart").toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, new StringBuilder(TAG).append("onResume").toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, new StringBuilder(TAG).append("onPause").toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, new StringBuilder(TAG).append("onRestart").toString());
    }
}
