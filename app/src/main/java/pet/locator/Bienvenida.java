package pet.locator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ViewFlipper;

/**
 * Created by NSSektor on 7/21/15.
 */
public class Bienvenida extends Activity {

    private ViewFlipper myViewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bienvenida);

        myViewFlipper = (ViewFlipper) findViewById(R.id.myflipper);
        myViewFlipper.setFlipInterval(2000);
        myViewFlipper.setAutoStart(true);
        myViewFlipper.startFlipping();


    }

    @Override
    protected void onPause(){
        super.onResume();
        ViewGroup view = (ViewGroup) getWindow().getDecorView().getRootView();
        loopQuestions(view);
    }


    private void loopQuestions(ViewGroup parent) {
        for(int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);

            if(child instanceof EditText) {
                //Support for EditText
                EditText et = (EditText)child;
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
            }


            if(child instanceof ViewGroup) {
                //Nested Q&A
                ViewGroup group = (ViewGroup)child;
                loopQuestions(group);
            }
        }
    }


}
