package packs.classes;

import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
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
    Prov []province;
    public Map(String mn,int mz)
    {
        this.MapName=mn;
        this.MapSize=mz;
         province=new Prov[MapSize*MapSize];
        for(int i=0;i<MapSize*MapSize;i++)
       {province[i]=new Prov();
           province[i].numb=i;
       }
    }

    public Map()
    {
        this.MapName=null;
        this.MapSize=0;

    }
    void SetArr(int mapsize)
    {
        this.province=new Prov[mapsize*mapsize];
        for(int i=0;i<mapsize*mapsize;i++)
        {this.province[i]=new Prov();}

    }
   public void Mapsave()
    {
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/ETALON");
            if (!myDir.exists()) {
                myDir.mkdirs();
            }

            String fname = MapName+".txt";
            File file = new File (myDir, fname);
            if (file.exists ())
                file.delete ();

            FileOutputStream out = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter writer = new BufferedWriter(osw);
            writer.write("Name("+this.MapName+".txt)");
            writer.write("\nSize("+MapSize+")");
            for(int j=0;j<MapSize*MapSize;j++)
            {

                writer.write("\nPr["+province[j].numb+"]{"+"Bi=("+province[j].biome+")" + "Ob=("+province[j].object+")"+"Bu=("+province[j].build+")" +"Co=("+province[j].country+")}" );

            }
             writer.close();
            osw.close();
        } catch (Throwable t) {

            return;
        }

    }



  public   void Mapload(int n)
    {
        String arr;
        String lname;
        String lsize;
       String curr;
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/ETALON");
            if (!myDir.exists()) {

            }
            File[] files = myDir.listFiles();
            File cur = files[n];
            FileInputStream inputStream = new FileInputStream(cur);
            /*
             * Буфферезируем данные из выходного потока файла
             */
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            /*
             * Класс для создания строк из последовательностей символов
             */
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                /*
                 * Производим построчное считывание данных из файла в конструктор строки,
                 * Псоле того, как данные закончились, производим вывод текста в TextView
                 */

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                arr=stringBuilder.toString();

                int index1;
                int index2;
                index2 = arr.lastIndexOf("txt")+3;
                index1=arr.lastIndexOf("Name")+5;
                String name=arr.substring(index1, index2);
                index1=arr.lastIndexOf("Size")+5;
                index2 =arr.lastIndexOf("Pr[0]")-2;
                String z=arr.substring(index1,index2);
                int size=Integer.parseInt(z);
                this.MapName=name;
                this.MapSize=size;
                for(int i=0;i<size*size;i++)
                {double prom;
                    if(i==0)
                    {prom=1;}
                    else
                    {prom=Math.ceil(Math.log10(i+0.5));}
                    index1=arr.lastIndexOf("Pr["+i+"]")+8+(int)prom;
                    index2 =arr.lastIndexOf("Pr["+i+"]")+9+(int)prom;
                    this.province[i].biome=Integer.parseInt(arr.substring(index1,index2));
                    index1=arr.lastIndexOf("Pr["+i+"]")+13+(int)prom;
                    index2 =arr.lastIndexOf("Pr["+i+"]")+14+(int)prom;
                    this.province[i].object=Integer.parseInt(arr.substring(index1,index2));
                    index1=arr.lastIndexOf("Pr["+i+"]")+18+(int)prom;
                    index2 =arr.lastIndexOf("Pr["+i+"]")+19+(int)prom;
                    this.province[i].build=Integer.parseInt(arr.substring(index1,index2));
                    index1=arr.lastIndexOf("Pr["+i+"]")+23+(int)prom;
                    index2 =arr.lastIndexOf("Pr["+i+"]")+24+(int)prom;
                    this.province[i].country=Integer.parseInt(arr.substring(index1,index2));
                }



               // this.MapName= stringBuilder.toString();
            } catch (Throwable t) {
                return;
            }
        }
        catch(Throwable t)
        {return;}
    }


    public void MapFillRand()
    {
        int Ldiap=0;
        int Rdiap=4;
        int Rand=0;
        for(int i=0;i<MapSize*MapSize;i++)
        {
          Rand=Ldiap + (int) (Math.random() * Rdiap);
          province[i].biome=Rand;
        }

    }
    void Provred(int i, int b, int o, int bu, int co)
    {
        province[i].biome=b;
        province[i].object=o;
        province[i].build=bu;
        province[i].country=co;
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
