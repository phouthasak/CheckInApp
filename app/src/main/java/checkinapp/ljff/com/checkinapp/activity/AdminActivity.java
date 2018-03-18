package checkinapp.ljff.com.checkinapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import checkinapp.ljff.com.checkinapp.R;

/**
 * Created by Phouthasak Douanglee on 3/17/2018.
 */

public class AdminActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void goToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pushData(View view){
        DialogInterface.OnClickListener pushDataDialogClickListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Push the data here
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(R.string.pushDataWarning)
                .setPositiveButton("Yes", pushDataDialogClickListener)
                .setNegativeButton("No", pushDataDialogClickListener)
                .show();
    }

    public void pullData(View view){
        DialogInterface.OnClickListener pullDataDialogClickListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Pull the data here
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(R.string.pullDataWarning)
                .setPositiveButton("Yes", pullDataDialogClickListener)
                .setNegativeButton("No", pullDataDialogClickListener)
                .show();
    }
}
