package packs.classes;

import java.util.ArrayList;

import packs.assets.TerrAsset;

public class Objects
{
    public static ArrayList<DrawObject> objects=new ArrayList<>();

   public static void addobj()
    {
        // for(int i=0;i<20;i++)
        int y=24;
        objects.add(new DrawObject(TerrAsset.grass,10,y*0,0));
        objects.add(new DrawObject(TerrAsset.sand,10,y*2,0));
        //objects.add(new DrawObject(TerrAsset.stone,10,y*4,0));
        objects.add(new DrawObject(TerrAsset.water,10,y*6,0));
        objects.add(new DrawObject(TerrAsset.ice,10,y*8,0));
    }
}
