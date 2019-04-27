package packs.activities;

import packs.activities.R;
import packs.gfx.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.view.WindowManager;
import android.widget.EditText;

public class SinglePlayerOpt extends Activity {
    String NewMapNameS;
     int NewMapZizeS;
    EditText TextNMNS;
    EditText TextNMZS;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.playoptions);
        TextNMNS = (EditText) findViewById(R.id.editText2);
        TextNMZS = (EditText) findViewById(R.id.editText3);
        Button BackButton = findViewById(R.id.BackButtonSinOp);
        // Устанавливаем действие по нажатию
        BackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(SecAct);
            }
        });

        Button RedactButton = findViewById(R.id.CreateButtonSinOp);
        // Устанавливаем действие по нажатию
        RedactButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                NewMapNameS=TextNMNS.getText().toString();
                NewMapZizeS=Integer.parseInt(TextNMZS.getText().toString());
      //          MapPanel.sizeX=NewMapZizeS;
//                MapPanel.sizeY=NewMapZizeS;
                Intent SecAct = new Intent(getApplicationContext(), SinglePlayer.class);
                startActivity(SecAct);
            }
        });
    }


}
