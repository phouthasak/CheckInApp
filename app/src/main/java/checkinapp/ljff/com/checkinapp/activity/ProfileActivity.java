package checkinapp.ljff.com.checkinapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.entity.Student;
import checkinapp.ljff.com.checkinapp.util.Util;

/**
 * Created by Phouthasak Douanglee on 3/16/2018.
 */

public class ProfileActivity extends AppCompatActivity{
    private TextView tvStudentID, tvFirstName, tvLastName, tvSchoolName, tvGuest;
    private CheckBox cbMediaWavier;
    private ImageView ivProfile;
    private Student student;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Util util = new Util();
        student = intent.getParcelableExtra("student");
        ivProfile = findViewById(R.id.ivProfile);
        tvStudentID =  findViewById(R.id.tvStudentID);
        tvFirstName =  findViewById(R.id.tvFirstName);
        tvLastName =  findViewById(R.id.tvLastName);
        tvSchoolName =  findViewById(R.id.tvSchoolName);
        cbMediaWavier = findViewById(R.id.cbMediaWavier);
        tvGuest =  findViewById(R.id.tvGuest);

        String resourceName = "s" + String.valueOf(student.getStudentId());

        if(util.checkForDrawableExist(getApplicationContext(), resourceName))
            ivProfile.setImageResource(getApplicationContext().getResources().getIdentifier(resourceName, "drawable", getApplicationContext().getPackageName()));

        tvStudentID.setText(String.valueOf(student.getStudentId()));
        tvFirstName.setText(student.getFname());
        tvLastName.setText(student.getLname());
        tvSchoolName.setText(student.getSchoolName());
        cbMediaWavier.setChecked(student.isMediaWavier());
        tvGuest.setText(String.valueOf(student.getGuests()));

        Log.d("StudentID", String.valueOf(student.getId()));
        Log.d("StudentName", student.getFname() + " " + student.getLname());
        Log.d("StudentSchool", student.getSchoolName());
        Log.d("MediaWavier", String.valueOf(student.isMediaWavier()));
        Log.d("Guests", String.valueOf(student.getGuests()));
    }

    public void checkIn(final View view){
        student.setCheckedIn(true);
        Toast.makeText(getApplicationContext(), R.string.checkInComplete, Toast.LENGTH_LONG).show();
    }
}
