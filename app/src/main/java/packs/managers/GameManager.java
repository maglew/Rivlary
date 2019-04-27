package packs.managers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import packs.activities.MainActivity;
import packs.activities.R;
import packs.assets.TerrAsset;
import packs.core.MainThread;

public class GameManager
{
    private MainThread mainThread;
    private Activity MA;

    public GameManager(Activity  MA)
    {
        this.MA=MA;
        //  Options.startupOptions();
    }
    public   void game_init()
    {
        TerrAsset.terr_asset_init(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(),R.drawable.textures)));
    }


}