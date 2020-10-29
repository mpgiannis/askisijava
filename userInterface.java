import java.io.File;
import java.util.Scanner;

public class userInterface {

    private static Scanner eisodos_xristi = new Scanner(System.in);
    //private static Check checking;
    static UserInputHandler checking= new UserInputHandler();

    public static File getfile_with_data(){

        System.out.println("Δώσε αρχείο dataset");
        String eisodos_data;
        eisodos_data = eisodos_xristi.nextLine();
        while(checking.checkFOrfile(eisodos_data)){
            System.out.println("Δώσε αρχείο dataset");
            eisodos_data = eisodos_xristi.nextLine();
        }
        File arxeio_data = new File(eisodos_data);
        return arxeio_data;

    }
    public static File getfile_configur(){

        System.out.println("Δώσε αρχείο config");
        String eisodos_config;
        eisodos_config = eisodos_xristi.nextLine();
        while(checking.checkFOrfile(eisodos_config)){
            System.out.println("Δώσε αρχείο config");
            eisodos_config = eisodos_xristi.nextLine();
        }
        File arxeio_config = new File(eisodos_config);
        return arxeio_config;

    }

    public static String get_new_file_name(){

        System.out.println("Δώσε παραγώμενο αρχείο");
        String eisodos_paragomeno;
        eisodos_paragomeno = eisodos_xristi.nextLine();
        return eisodos_paragomeno;


    }



}
