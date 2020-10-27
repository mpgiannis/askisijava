import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class encrypt {
   File dedomena;
   File configuration;
   String onoma_arxeiou;
   int nooflines = 0;
   String line;


    encrypt(File x, File a,String b){
        this.dedomena=x;
        this.configuration=a;
        this.onoma_arxeiou=b;

    }



    public void doencrypt() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Scanner data = new Scanner(new FileReader(dedomena));
        data.useDelimiter("\\t");
        line = data.nextLine();
        int[] stiles_gia_kriptografisi=euresiPedion(line,configuration);
        int arithmos_stilon=line.split("\t").length;
        FileWriter newfile = new FileWriter(onoma_arxeiou);
        newfile.write(line + '\n');
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecretKey skey = kgen.generateKey();
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.ENCRYPT_MODE, skey);
        while (data.hasNextLine())
        {
            line = data.nextLine();
            String[] pinakas1 =line.split("\t");
            for (int i = 0; i < arithmos_stilon; i++)
            {
                if (contains(stiles_gia_kriptografisi,i)) {
                    byte[] input = pinakas1[i].getBytes("UTF-8");
                    byte[] encoded = ci.doFinal(input);
                    newfile.write(String.valueOf(encoded) + '\t');
                }
                else {newfile.write(pinakas1[i] + '\t');}
            }
            newfile.write('\n');
        }
        newfile.close();
        data.close();

    }






    //DIMIOURGO ENAN PINAKA MEGETHOUS OSES KAI OI GRAMMES TOU ARXEIOU CONFIG
    //KAI TOPOTHETO APO TO ARXEIO DATASET TON ARITHMO TIS STILIS POU PREPEI NA KRIPTOGRAFITHEI
    public int[] euresiPedion(String grami,File arxeio) throws FileNotFoundException
    {
        int arithmos_stilon=grami.split("\t").length;
        int[] array = new int[NoOflines(configuration)];
        int stili=0;
        String[] pinakas =grami.split("\t");
        Scanner config = new Scanner(new FileReader(configuration));
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


    //VRISEI TON ARITHMO TON GRAMMON TOU ARXEIOU CONFIG
     public int NoOflines(File k) throws FileNotFoundException
     {
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





}
