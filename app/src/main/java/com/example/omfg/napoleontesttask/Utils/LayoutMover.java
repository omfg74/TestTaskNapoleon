package com.example.omfg.napoleontesttask.Utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class LayoutMover implements View.OnTouchListener {

    private GestureDetector gestureDetector;
    public LayoutMover(Context context) {

gestureDetector = new GestureDetector(context,new GestuerListner());
    }
    private class GestuerListner extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Boolean result = false;
            float diffx = e1.getX()-e2.getX();

            if(diffx>10){
                onSwipe();

            }
            result =true;


            return result;
        }
    }
    public void onSwipe(){

        System.out.println("SWIPE");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }
}
