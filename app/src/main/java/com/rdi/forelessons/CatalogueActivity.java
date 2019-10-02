package com.rdi.forelessons;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogueActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private final String SAVE_PARCEL = "SAVE_PARCEL";

    private TestModel testModel;
    public Button mButton;
    public Button mButtonGoToAdress;

    public TextView mTextFieldOne;
    public TextView mTextFieldTwo;
    public TextView mTextFieldListOne;
    public TextView mTextFieldListTwo;
    public EditText mEditTextAdres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogue_activity);
        setTitle(R.string.catalogue_activity_name);
        testModel = new TestModel();
        testModel.initializationOfVariablesByRandom();
        setUI();
        filUI();
        Log.d(TAG, new StringBuilder(TAG).append("onCreate").toString());
    }

    private void setUI() {
        mButton = findViewById(R.id.button);
        mButtonGoToAdress = findViewById(R.id.buttonGoToAdres);
        mButton.setOnClickListener(this::onClick);
        mButtonGoToAdress.setOnClickListener(this::onClick);
        mTextFieldOne = findViewById(R.id.text_string_one);
        mTextFieldTwo = findViewById(R.id.text_string_two);
        mTextFieldListOne = findViewById(R.id.text_list_string_one);
        mTextFieldListTwo = findViewById(R.id.text_list_string_two);
        mEditTextAdres = findViewById(R.id.editText);
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

        if (view.getId() == R.id.button) {
            Intent intent = new Intent(this, MapActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Log.d(TAG, new StringBuilder(TAG).append("onClick").toString());

        } else {
            Uri address = Uri.parse(mEditTextAdres.getText().toString());
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            } else {
                Log.d("Intent", "Не получается обработать намерение!");
            }
        }
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
