package packs.activities;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import packs.activities.R;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class RedOptMenu extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.red_opt_menu);




        Button LoadMap = findViewById(R.id.LoadButtRedMenu);
        LoadMap.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), MapLoad.class);
                startActivity(SecAct);
            }
        });


        Button CreateMap = findViewById(R.id.CreateButtRedMenu);
        CreateMap.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), MapCreate.class);
                startActivity(SecAct);
            }
        });




        Button BackButton = findViewById(R.id.BackButtRedMenu);
        BackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(SecAct);
            }
        });




    }

}
