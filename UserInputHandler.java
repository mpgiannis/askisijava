import java.io.File;
import java.util.regex.*;

public class UserInputHandler {

public boolean checkFOrfile(String string){
    if(string.isEmpty() || string==null)
    {
        System.out.println("Δεν δόθηκε αρχείο");
        return true;

    }
    else{
        String extension = "";
        int i = string.lastIndexOf('.');
        if (i > 0) {
            extension = string.substring(i+1);
        }
        if(!extension.equals("txt")){
            System.out.println("Δώσε txt αρχείο");
            return true;
        }
        else {
            File filename = new File(string);
            if(!filename.exists() || filename.isDirectory()){
                System.out.println("Δεν υπάρχει το αρχείο");
                return true;

            }
            else return false;
        }
    }
}

public boolean checkEpilogi(String s){
    Pattern pattern = Pattern.compile("^\\D*\\d\\D*$");
    Matcher m = pattern.matcher(s);
    int number;
    if((m.matches()) && ((Integer.parseInt(s)==1) || (Integer.parseInt(s)==2) ) )
    {
        return true;
    }
    else return false;
}





}
