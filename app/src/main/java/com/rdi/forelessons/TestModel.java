package com.rdi.forelessons;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel implements  Parcelable {
    private String fieldOne;
    private String fieldTwo;
    private List<String> firstList;
    private List<String> secondList;

    public TestModel() {
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "TestModel{" +
                "fieldOne='" + fieldOne + '\'' +
                ", fieldTwo='" + fieldTwo + '\'' +
                ", firstList=" + firstList +
                ", secondList=" + secondList +
                '}';
    }



    public TestModel(String fieldOne, String fieldTwo, List<String> firstList, List<String> secondList) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.firstList = firstList;
        this.secondList = secondList;
    }

    protected TestModel(Parcel in) {
        fieldOne = in.readString();
        fieldTwo = in.readString();
        firstList = in.createStringArrayList();
        secondList = in.createStringArrayList();
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public List<String> getFirstList() {
        return firstList;
    }

    public void setFirstList(List<String> firstList) {
        this.firstList = firstList;
    }

    public List<String> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<String> secondList) {
        this.secondList = secondList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fieldOne);
        parcel.writeString(fieldTwo);
        parcel.writeStringList(firstList);
        parcel.writeStringList(secondList);
    }


    public void initializationOfVariablesByRandom() {
        Random random = new Random();
        fieldOne = random.nextInt(100) + "";
        fieldTwo = random.nextInt(100) + "";

        firstList.add(random.nextInt(100) + "");
        firstList.add(random.nextInt(100) + "");
        firstList.add(random.nextInt(100) + "");
        secondList.add(random.nextInt(100) + "");
        secondList.add(random.nextInt(100) + "");
        secondList.add(random.nextInt(100) + "");

        Log.d("TestModel", "initializationOfVariablesByRandom: " + this.toString());

    }
}
