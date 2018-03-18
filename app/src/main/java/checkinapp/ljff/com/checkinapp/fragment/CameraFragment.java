package checkinapp.ljff.com.checkinapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import checkinapp.ljff.com.checkinapp.activity.ProfileActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class CameraFragment extends Fragment implements ZXingScannerView.ResultHandler{
    private ZXingScannerView scannerView;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInBundle){
        super.onCreate(savedInBundle);
        scannerView = new ZXingScannerView(getActivity());
        scannerView.setResultHandler(this);
        Log.w("Test", "In OnCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("Test", "In OnCreateView");
        return scannerView;
    }

    @Override
    public void onStart(){
        Log.w("Test", "In OnStart");
        super.onStart();
        scannerView.startCamera();
    }

    @Override
    public void onResume(){
        Log.w("Test", "In OnResume");
        super.onResume();
        scannerView.resumeCameraPreview(this);
    }

    @Override
    public void onPause(){
        Log.w("Test", "In OnPause");
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.w("Test", "In HandleResult");
        String studentId = result.getText();
        scannerView.stopCamera();
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        intent.putExtra("studentId", studentId);
        getActivity().startActivity(intent);
    }
}
