import java.util.Scanner;

public class CeaserCipher {
    private static Scanner input = new Scanner(System.in);
    private static boolean run = true;

    public static void run (){

        while(run){
            System.out.println("""
                    1. cipher
                    2. decode
                    3. break
                    4. quit
                    Enter choice:""");
            String action = input.nextLine();
            input.nextLine();


            switch (action) {
                case "1" -> Cipher();
                case "2" -> Decode();
                case "3" -> Decoder();
                case "4" -> run = false;
                default -> System.out.println("Invalid input. Restart program");
            }
        }

    }

    private static void Decode() {
        System.out.println("Message you want to decode: ");
        String message = input.nextLine();
        System.out.println("With what key: ");
        int key = input.nextInt();
        String decoded = "";

        for (int i =0; i<message.length(); i++){
            if ((char)message.charAt(i) == ' '){
                decoded += " ";
            }
            else {
                char letter = (char) (message.charAt(i)-key);
                if ((int) letter < 32){
                    letter += 94;
                }
                decoded += letter;
            }
        }
        System.out.println(decoded);
    }

    private static void Cipher() {
        System.out.println("Message you want to cipher: ");
        String message = input.nextLine();
        System.out.println("With what key: ");
        int key = input.nextInt();
        String encript = "";

        for (int i =0; i<message.length(); i++){
            if ((char)message.charAt(i) == ' '){
                encript += " ";
            }
            else {
                char letter = (char) (message.charAt(i)+key);
                if ((int) letter >126){
                    letter -= 95;
                }
                encript += letter;
            }
        }
        System.out.println(encript);
    }

    private static void Decoder (){
        System.out.println("Message you want to decode: ");
        String text = input.nextLine();

        int counter = 0;
        int counterBig = 0;
        char charBig = '{';

        for (int i = 0; i<text.length(); i++){
            for (int j =0; j<text.length();j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    counter++;
                }
            }
            if (counter > counterBig){
                counterBig = counter;
                charBig = text.charAt(i);
            }
            counter = 0;
        }
        int key = (int)charBig - (int)'e';

        System.out.println("the key is: "+key);

        String textFinal = "";
        for (int i = 0; i< text.length(); i++){
            if (text.charAt(i) == ' '){
                textFinal += ' ';
            }
            else {
                textFinal += (char) ((int)text.charAt(i) - key);
            }
        }
        System.out.println("the decoded message is: "+textFinal);

    }
}
