package com.example.skbarcodexzing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.journeyapps.barcodescanner.camera.AutoFocusManager;

import java.util.List;




public class BarcodeReaderFragment extends Fragment  {
    BeepManager beepManager;
    BarcodeFormat barcodeFormat;
    AutoFocusManager autoFocusManager;

    private CompoundBarcodeView barcodeView;


    public BarcodeReaderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_barcode_reader, container, false);
        barcodeView = (CompoundBarcodeView)view.findViewById(R.id.barcode_scanner);
        barcodeView.decodeContinuous(callback);
        barcodeView.isSoundEffectsEnabled();
        beepManager=new BeepManager(getActivity());
       // barcodeFormat=new BarcodeFormat(getActivity());
        ;

        return view;
    }

    @Override
    public void onResume() {
        barcodeView.resume();
        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeView.pause();
        super.onPause();
    }



    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {


           // barcodeView.pause();
            beepManager.playBeepSoundAndVibrate();
            if (result.getText() != null) {
                barcodeView.setStatusText(result.getText());

                Log.d("TAG", "result" + result.getText());
            }

        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {



        }



    };

}
