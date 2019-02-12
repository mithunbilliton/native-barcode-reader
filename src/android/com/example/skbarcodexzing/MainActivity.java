package com.example.skbarcodexzing;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    BarcodeReaderFragment barcodeReaderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        barcodeReaderFragment = new BarcodeReaderFragment();
        ft.replace(R.id.fm_container, barcodeReaderFragment);
        ft.commit();


    }


   /* @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
