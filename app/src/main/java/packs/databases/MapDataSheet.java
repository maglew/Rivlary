package packs.databases;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import packs.activities.R;
import packs.assets.TerrAsset;

public class MapDataSheet
{
    private static ArrayList<MapInfo> objects = new ArrayList<>();
    public static void init(Activity MA)
    {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inScaled=false;
        TerrAsset.terr_asset_init(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.textures)));
        objects.add(new MapInfo(1,TerrAsset.sand,0,1,2,3,2));



    }
    public static class MapInfo
    {

        public int ID;
        public int x;
        public int y;
        public Bitmap image;
        public int biome;
        public int building;
        public int unit;
        public int object;
        //public Map<Integer,Integer> madeFrom;


        MapInfo(int ID,Bitmap image,int x,int y,int biome,int unit,int object)
        {

            this.ID=ID;
            this.x=x;
            this.y=y;
            this.image=image;
            this.biome=biome;
            this.unit=unit;
            this.object=object;
           //madeFrom=new HashMap<Integer,Integer>();

        }

    }


}
