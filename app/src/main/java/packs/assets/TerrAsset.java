package packs.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import packs.activities.R;

public class TerrAsset
{
    public static Bitmap grass,sand,stone,water,ice;
    private static int width=24;
    private static int height=24;
    public static void terr_asset_init(Bitmap sheet)
    {
        SpriteSheet tsheet=new SpriteSheet(sheet);
       // grass=tsheet.crop(7,3);
       // sand=tsheet.crop(6,3);
       // stone=tsheet.crop(1,1);
       // water=tsheet.crop(0,0);
       // ice=tsheet.crop(5,3);
        grass=tsheet.crop(120, 48, width, height);
        sand=tsheet.crop(96, 48, width, height);
        water=tsheet.crop(0, 0, width, height);
        ice=tsheet.crop(72, 48, width, height);
    }
}
