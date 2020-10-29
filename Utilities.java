import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Utilities {

    //VRISEI TON ARITHMO TON GRAMMON TOU ARXEIOU
    public int NoOflines(File k) throws FileNotFoundException
    {
        int nooflines = 0;
        Scanner data1 = new Scanner(new FileReader(k));
        while (data1.hasNextLine()) {
            data1.nextLine();
            nooflines++;
        }
        data1.close();
        return nooflines;
    }

    //EPISTREFEI TRUE AN IPARXEI O ARTHMOS MESA STON PINAKA
    public boolean contains(int[] array, int v)
    {
        boolean result = false;
        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }
        return result;
    }

    //DIMIOURGO ENAN PINAKA MEGETHOUS OSES KAI OI GRAMMES TOU ARXEIOU CONFIG
    //KAI TOPOTHETO APO TO ARXEIO DATASET TON ARITHMO TIS STILIS POU PREPEI NA KRIPTOGRAFITHEI
    public int[] euresiPedion(String grami,File arxeio) throws FileNotFoundException
    {
        int arithmos_stilon=grami.split("\t").length;
        int[] array = new int[NoOflines(arxeio)];
        int stili=0;
        String[] pinakas =grami.split("\t");
        Scanner config = new Scanner(new FileReader(arxeio));
        while (config.hasNextLine()) {
            String confi = config.nextLine();
            for (int i = 0; i < arithmos_stilon; i++) {
                if (pinakas[i].equals(confi)) {
                    array[stili] = i;
                }
            }
            stili++;
        }
        config.close();
        return array;
    }

}
