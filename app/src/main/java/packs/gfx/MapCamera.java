package packs.gfx;


import android.graphics.Rect;
import android.graphics.RectF;

public class MapCamera
{
    RectF cambox=new RectF();
    float width,height;
    float x=0;
    float y=0;
    public MapCamera(float width,float height)
    {
      cambox.set(0,0,width,height);
        this.height=height;
        this.width=width;
    }
    public void setworldlocation(float x,float y)
    {
      cambox.set(x,y,width+x,height+y);
        this.x=x;
        this.y=y;
    }
    public RectF getrect()
    {
        return cambox;
    }
    public float getx()
    {
       return x;

    }
    public float gety()
    {
       return y;

    }
}
