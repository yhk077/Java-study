import java.util.Scanner;
public class homework526a{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        //String regex = "\\D+";
        //String[] digital = str.split(regex);
        String[] digital = str.split("\\D+");
        for(int i=0;i<digital.length;i++){
            System.out.print(digital[i]);
        }
    }
}