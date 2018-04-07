package checkinapp.ljff.com.checkinapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.adapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity{
    private int previousState, currentState;
    private ViewPager viewPager;
    private MainPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View background = (View) findViewById(R.id.am_background_view);
        viewPager = (ViewPager) findViewById(R.id.am_view_pager);
        adapter = new MainPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);
    }

    public void goToAdminPage(final View view){
        DialogInterface.OnClickListener adminDialogClickListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(view.getContext(),AdminActivity.class);
                        startActivity(intent);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(R.string.adminWarning)
                .setPositiveButton("Yes", adminDialogClickListener)
                .setNegativeButton("No", adminDialogClickListener)
                .show();
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.e("onPageScrolled", "pageSelected: " + position
                    + ",positionOffset:" + positionOffset
                    + ",positionOffsetPixel:" + positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            Log.e("onPageSelected", "pageSelected: " + position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
//             Removed till I can find a nicer way to allow for wrap around
//            Log.e("onPageScrollStateChange", "state:" + state);
//            int currentPage = viewPager.getCurrentItem();
//            if (currentPage == 2 || currentPage == 0) {
//                previousState = currentState;
//                currentState = state;
//                if (previousState == 1 && currentState == 0) {
//                    viewPager.setCurrentItem(currentPage == 0 ? 2 : 0);
//                }
//            }

        }
    };
}
