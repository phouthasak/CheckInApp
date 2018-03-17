package checkinapp.ljff.com.checkinapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import checkinapp.ljff.com.checkinapp.R;

/**
 * Created by Phouthasak Douanglee on 3/16/2018.
 */

public class ProfileActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.studentNumber);
        textView.setText(intent.getStringExtra("studentId"));
    }
}
