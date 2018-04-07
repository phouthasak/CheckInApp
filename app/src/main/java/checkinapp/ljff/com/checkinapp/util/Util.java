package checkinapp.ljff.com.checkinapp.util;

import android.content.Context;

/**
 * Created by Phouthasak Douanglee on 4/7/2018.
 */

public class Util {
    public boolean checkForDrawableExist(Context context, String file){
        int hasFile = context.getResources().getIdentifier(file, "drawable", context.getPackageName());
        if(hasFile != 0){
            return true;
        }else{
            return false;
        }
    }
}
