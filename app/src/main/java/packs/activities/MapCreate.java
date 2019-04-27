package packs.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import packs.activities.R;


public class MapCreate extends Activity
{
    String NewMapName;
    public static int NewMapZize;

    EditText TextNMN;
    EditText TextNMZ;
    public static pack.objects.Map newmap;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mapcreate);

        TextNMN = (EditText) findViewById(R.id.editText2);
        TextNMZ = (EditText) findViewById(R.id.editText3);


        Button LoadMap = findViewById(R.id.CreateMapButt);
        LoadMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                NewMapName=TextNMN.getText().toString();
                NewMapZize=Integer.parseInt(TextNMZ.getText().toString());
          //      MapPanel.sizeX=NewMapZize;
          //      MapPanel.sizeY=NewMapZize;
          //      newmap=new Map(NewMapName,NewMapZize);
                //newmap.Mapsave();
                Intent SecAct = new Intent(getApplicationContext(), Redactor.class);
                startActivity(SecAct);
            }
        });







        Button BackButton = findViewById(R.id.BackButtMapCreate);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), RedOptMenu.class);
                startActivity(SecAct);
            }
        });




    }

}
