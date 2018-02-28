package com.example.mansopresk01.intentimages;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mansopresk01 on 11/10/2017.
 */

public class L {
    public static void m(String message)
    {
        Log.d("prathyu",message);
    }
    public static void s (Context context,String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
