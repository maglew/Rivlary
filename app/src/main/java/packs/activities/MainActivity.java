package packs.activities;

import packs.activities.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.view.WindowManager;




public class MainActivity extends Activity {

    //MapPanel mapPanel;

    //Состояние кнопки редактирования/сдвига
    //public Boolean edit_move_Condition = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu);

        Button RedactButton = findViewById(R.id.RedactButton);
        // Устанавливаем действие по нажатию
        RedactButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), RedOptMenu.class);
                startActivity(SecAct);
            }
        });


        Button SingleButton = findViewById(R.id.Singlebutton);
        // Устанавливаем действие по нажатию
        SingleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), SinglePlayer.class);
                startActivity(SecAct);
            }
        });
    }

}