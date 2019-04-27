package packs.classes;


import android.graphics.Bitmap;
import android.graphics.Canvas;

public class DrawObject
{
Bitmap image;
float x=0,y=0;
float rotation=0;
boolean renderable=false;
public  DrawObject(Bitmap image,float x,float y,float rotation)
{
    this.image=image;
    this.x=x;
    this.y=y;
    this.rotation=rotation;
}

public  void tick()
{
  // if(x<300)
 //  {

  //     x+=0.1;
 //  }
//    rotation+=1;
}
public  void render(Canvas canvas)
{
   // if(!renderable)
    //    return;
    canvas.save();
    canvas.rotate(rotation,x+image.getWidth()/2,y+image.getHeight()/2);
    canvas.drawBitmap(image,x,y,null);
    canvas.restore();
}
public float getX()
{
    return x;
}
    public float getY()
    {
        return y;
    }

  //  public void setRenderable(boolean renderable)
   // {
   //     this.renderable=renderable;

  //  }
}
