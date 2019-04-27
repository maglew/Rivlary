package packs.gfx;


import packs.activities.R;
import packs.classes.DrawObject;
import packs.core.*;

import android.app.Activity;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;

import android.graphics.Canvas;
import android.graphics.*;


import android.util.*;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Iterator;

import packs.managers.GameManager;

import  packs.assets.TerrAsset;
import  packs.classes.Objects;

public class MapPanel extends SurfaceView implements SurfaceHolder.Callback
{

    private MainThread mainThread;
    private GameManager gameManager;
 //   private MapCamera cam;



    public MapPanel(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        getHolder().addCallback(this);
       //   Point screensize=new Point();
      //  (   (WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealSize(screensize);
//cam=new MapCamera(screensize.x-20,screensize.y-20);
        mainThread= new MainThread(getHolder(),this);
        //init(findViewById(R.drawable.textures));
        Activity MA=(Activity)context;
        //gameManager=MA.getGameManager();
       // GameManager.game_init();

    }


    @Override
    public void surfaceCreated(SurfaceHolder p1)
    {
       // ice = BitmapFactory.decodeResource(getResources(), R.drawable.ice);


Objects.addobj();
        mainThread.setRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
    {
        // TODO: Implement this method

    }

    public void tick()
    {
        Iterator <DrawObject> iter=Objects.objects.iterator();
       while(iter.hasNext())
        {

            DrawObject motemp=iter.next();
        //    motemp.setRenderable(cam.getrect().contains(motemp.getX(),motemp.getY()));
            motemp.tick();
       }
    }
    public void render(Canvas canvas)
    {
        canvas.drawColor(Color.BLACK);
   //     canvas.drawBitmap(ice,0,0,new Paint());
   //    canvas.save();
      // canvas.translate(cam.getx(),cam.gety());
        Iterator <DrawObject> iter=Objects.objects.iterator();
       while(iter.hasNext())
        {

            DrawObject motemp=iter.next();
            motemp.render(canvas);
        }
    //    Paint p=new Paint();
     //   p.setColor(Color.RED);
      //  p.setStyle(Paint.Style.STROKE);
       // canvas.drawRect( cam.getrect(),p);
     //   canvas.restore();
    }




    @Override
    public void surfaceDestroyed(SurfaceHolder p1)
    {
        boolean retry = true;
        while(retry)
        {
            try{mainThread.setRunning(false);
                mainThread.join();
                retry=false;
            }catch(InterruptedException e)
            {e.printStackTrace();}
        }
    }

}

