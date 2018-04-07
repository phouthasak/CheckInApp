package checkinapp.ljff.com.checkinapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/16/2018.
 */

public class ProfileActivity extends AppCompatActivity{
    private Student student;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        student = intent.getParcelableExtra("student");
        TextView textView = (TextView) findViewById(R.id.studentNumber);

        Log.d("StudentID", String.valueOf(student.getId()));
        Log.d("StudentName", student.getFname() + " " + student.getLname());
        Log.d("StudentSchool", student.getSchoolName());
        Log.d("MediaWavier", String.valueOf(student.isMediaWavier()));
        Log.d("Guests", String.valueOf(student.getGuests()));
    }
}
