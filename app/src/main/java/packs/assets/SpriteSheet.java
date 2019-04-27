package packs.assets;

import android.graphics.Bitmap;

public class SpriteSheet
{
    private Bitmap sheet;
    public SpriteSheet(Bitmap sheet)
    {
        this.sheet=sheet;
    }
    public Bitmap crop(int x,int y,int width,int height)
    {
        return Bitmap.createBitmap(sheet,x,y,width,height,null,false);
    }

}
