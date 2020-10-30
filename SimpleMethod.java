import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleMethod {

    Scanner data;
    int[] stiles_gia_kriptografisi;
    FileWriter newfile;
    Utilities util = new Utilities();

    SimpleMethod(Scanner a, int[] b, FileWriter c){
        this.data=a;
        this.stiles_gia_kriptografisi=b;
        this.newfile=c;
    }

    public void dosimple() throws IOException
    {
        String line;
        int arithmos_stilon;
        while (data.hasNextLine())
        {
            line = data.nextLine();
            arithmos_stilon=line.split("\t").length;
            String[] pinakas = line.split("\t");
            for (int i = 0; i < arithmos_stilon; i++) {
                if (util.contains(stiles_gia_kriptografisi, i)) {
                    for(int z=0;z< pinakas[i].length();z++)
                    {newfile.write("*" );}
                    newfile.write('\t');
                } else {
                    newfile.write(pinakas[i] + '\t');
                }
            }
            newfile.write('\n');
        }
        newfile.close();
        data.close();
    }
}
