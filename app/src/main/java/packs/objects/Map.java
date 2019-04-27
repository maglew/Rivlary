package pack.objects;

import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Map
{
    String MapName;
    int MapSize;
  //  int []cell;

    Prov []province;
    public Map(String mn,int mz)
    {
        this.MapName=mn;
        this.MapSize=mz;
         province=new Prov[MapSize*MapSize];
        for(int i=0;i<MapSize*MapSize;i++)
       {province[i]=new Prov();}
    }

    void Mapsave()
    {
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/ETALON");
            if (!myDir.exists()) {
                myDir.mkdirs();
            }

            String fname = MapName+"["+MapSize+"]"+".txt";
            File file = new File (myDir, fname);
            if (file.exists ())
                file.delete ();

            FileOutputStream out = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter writer = new BufferedWriter(osw);
            writer.write("Map("+this.MapName+")\n{");
            writer.write("\nscale("+MapSize+"*"+MapSize+"="+MapSize*MapSize+")");

            for(int j=0;j<MapSize*MapSize;j++)
            {

                writer.write("\nprovince("+j+")=["+province[j].numb+"]");
            }
            writer.write("\n}");
            writer.close();
            osw.close();
        } catch (Throwable t) {

            return;
        }

    }


    public class Prov
    {
        int numb;
        int biome;
        int object;
        int build;
        int country;
    public Prov(int num,int bio,int obj,int bui,int cou)
    {
         this.numb=num;
        this.biome=bio;
        this.object=obj;
        this.build=bui;
        this.country=cou;

    }
        public Prov()
        {
            this.numb=0;
            this.biome=0;
            this.object=0;
            this.build=0;
            this.country=0;

        }
    }
}
