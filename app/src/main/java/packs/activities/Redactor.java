package packs.activities;



import android.app.Activity;
import android.app.AlertDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.content.Intent;

import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import packs.gfx.MapPanel;
import packs.activities.R;


public class Redactor extends Activity
    {
        private String fileName ="Map";
        MapPanel mapPanel;
       // public String[] TempTerrain = {"grass", "sand", "water", "stone"};
        int temp=0;
        TextView selection;

        //Состояние кнопки редактирования/сдвига
        public Boolean edit_move_Condition = false;

        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            //requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.redact);

            selection = (TextView) findViewById(R.id.Current);

            // Устанавливаем действие по нажатию


                    mapPanel=findViewById(R.id.canvasPanelRed);
            //TextView temptext = findViewById(R.id.textView9);


            //textView.setText(temp);
            Button ExitButton = findViewById(R.id.ExitButtonR);
            // Устанавливаем действие по нажатию
            ExitButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent SecAct = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(SecAct);
                }
            });


            Button Save = findViewById(R.id.SaveButton);
            // Устанавливаем действие по нажатию
            Save.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    MapCreate.newmap.Mapsave();
                    // TODO Auto-generated method stub

                }
            });

                    // Кнопка редактирования/сдвига
                    Button edit_move = findViewById(R.id.edit_move);
                    // Устанавливаем действие по нажатию
                    edit_move.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            EMClick(view);
                        }
                    });


                    Button zoomin = findViewById(R.id.ZoominButton);
                    // Устанавливаем действие по нажатию
                   zoomin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
              //              Zoomin();
                        }
                    });


                    Button zoomout = findViewById(R.id.ZoomoutButton);
                    // Устанавливаем действие по нажатию
                    zoomout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
              //              Zoomout();
                        }
                    });

            Button TerButt = findViewById(R.id.TerButt);
            // Устанавливаем действие по нажатию
            TerButt.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showDialog(1);
                }
            });

            Button ResButton = findViewById(R.id.ResButton);
            // Устанавливаем действие по нажатию
            ResButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showDialog(2);
                }
            });

            Button BuildingsButton = findViewById(R.id.BuildingsButton);
            // Устанавливаем действие по нажатию
            BuildingsButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showDialog(3);
                }
            });

            Button YearButton = findViewById(R.id.YearButton);
            // Устанавливаем действие по нажатию
            YearButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showDialog(4);
                }
            });

            Button CountryButton = findViewById(R.id.CountryButton);
            // Устанавливаем действие по нажатию
            CountryButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showDialog(5);
                }
            });
            Button DropButton = findViewById(R.id.DropButton);
            // Устанавливаем действие по нажатию
            DropButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    temp=0;
                    selection.setText( temp+" ");
                }
            });





            }


     //   public void Zoomout()
     //   {mapPanel.scaleFactor-=0.25;}

     //   public void Zoomin()
     //   {mapPanel.scaleFactor+=0.25;}


        public void EMClick(View v)
        {
            // Нужно для получения картинок
            Resources res = getResources();
            // Получение самой кнопки
            Button EM = (Button)v;

            edit_move_Condition=!edit_move_Condition;
            // Включаем сдвиг
            if(edit_move_Condition) {
                // Получаем картинку
                Drawable img = res.getDrawable(R.drawable.move);
                // Устанавливаем картинку
                EM.setBackground(img);
       //         mapPanel.movable=true;
            }
            // Включаем редактирование
            else{
                // Получаем картинку
                Drawable img = res.getDrawable(R.drawable.edit);
                // Устанавливаем картинку
                EM.setBackground(img);
         //       mapPanel.movable=false;
            }
        }


        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case 1:{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    final String[] TempTerrain ={"Grass", "Water", "Sand","Ice"};

                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Change Terrain"); // заголовок для диалога

                    builder.setItems(TempTerrain, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            // TODO Auto-generated method stub
                            temp=item+1;
                            selection.setText( temp+":"+TempTerrain[item]);
                        }
                    });
                    builder.setCancelable(false);
                    return builder.create();}
                case 2:
                {AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    final String[] TempRes ={"Gold", "Silver", "Iron","Stone","Forest","Field","Grassland","Fish"};

                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Change Resources"); // заголовок для диалога

                    builder.setItems(TempRes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            // TODO Auto-generated method stub
                            temp=item+11;
                            selection.setText( temp+":"+TempRes[item]);
                        }
                    });
                    builder.setCancelable(false);
                    return builder.create();}
                case 3:
                { AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    final String[] TempBuild ={"Grass", "Water", "Sand","Stone"};

                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Change Buildings"); // заголовок для диалога

                    builder.setItems(TempBuild, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            // TODO Auto-generated method stub
                            temp=item+21;
                            selection.setText( temp+":"+TempBuild[item]);
                        }
                    });
                    builder.setCancelable(false);
                    return builder.create();}
                case 4:
                { AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    final String[] TempYear ={"XXX", "xxx", "XXX","xxx"};

                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("XXXXXX"); // заголовок для диалога

                    builder.setItems(TempYear, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            // TODO Auto-generated method stub
                            temp=item+31;
                            selection.setText( temp+":"+TempYear[item]);
                        }
                    });
                    builder.setCancelable(false);
                    return builder.create();}
                case 5:
                { AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    final String[] TempCountry ={"Red", "Blue", "Green","Yellow","Black","White"};

                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Change Terrain"); // заголовок для диалога

                    builder.setItems(TempCountry, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            // TODO Auto-generated method stub
                            temp=item+41;
                            selection.setText( temp+":"+TempCountry[item]);
                        }
                    });
                    builder.setCancelable(false);
                    return builder.create();}

                default:
                { return null;}
            }
        }



    }
