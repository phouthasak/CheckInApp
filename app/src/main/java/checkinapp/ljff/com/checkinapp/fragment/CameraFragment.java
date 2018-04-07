package checkinapp.ljff.com.checkinapp.fragment;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import java.util.List;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.activity.ProfileActivity;
import checkinapp.ljff.com.checkinapp.database.AppDatabase;
import checkinapp.ljff.com.checkinapp.entity.Student;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class CameraFragment extends Fragment implements ZXingScannerView.ResultHandler{
    private ZXingScannerView scannerView;
    private AppDatabase database;
    private List<Student> students;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInBundle){
        super.onCreate(savedInBundle);
        scannerView = new ZXingScannerView(getActivity());
        scannerView.setResultHandler(this);
        database = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "students").allowMainThreadQueries().build();
        students = database.studentsDAO().getStudents();
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
        boolean foundStudent = false;
        scannerView.stopCameraPreview();
        try{
            int studentId = Integer.parseInt(result.getText());
            for(Student student: students){
                if(studentId == student.getStudentId()){
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    intent.putExtra("student", student);
                    foundStudent = true;
                    getActivity().startActivity(intent);
                    break;
                }
            }

            if(foundStudent == false){
                Log.e("ScanningQRCode", "Student not found");
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(R.string.studentNotFound)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                scannerView.resumeCameraPreview(this);
            }
        }catch (NumberFormatException ex){
            Log.e("ScanningQRCode", "QR code cannot be converted to integer");
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(R.string.studentNotFound)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
            scannerView.resumeCameraPreview(this);
        }


    }
}
