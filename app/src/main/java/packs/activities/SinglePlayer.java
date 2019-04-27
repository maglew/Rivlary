package packs.activities;
import packs.activities.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import android.view.View.OnClickListener;

import packs.gfx.MapPanel;
import packs.managers.GameManager;


public class SinglePlayer extends Activity
{
    MapPanel mapPanel;

    //Состояние кнопки редактирования/сдвига
    private GameManager gameManager;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.singleplayer);


        // Устанавливаем действие по нажатию

        gameManager = new GameManager(this);
        mapPanel=findViewById(R.id.canvasPanelSing);
        prepareNewGame();
    }

    private void prepareNewGame()
    {

        gameManager.game_init();
    }



}
