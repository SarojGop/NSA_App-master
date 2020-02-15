import java.util.Scanner;
public class NSA_test {
    public static void main (String args[]) {
        login user_one = new login ();

        System.out.println (" Welcome to NSA TTU APP" + "\n\n" + "Are you a exsiting member?" + "\n\n" +
                "Press 1 for Yes, 0 for NO");
        Scanner input = new Scanner (System.in);
        int a = input.nextInt ();

        switch (a) {

            case 0:
                user_one.sign_Up ();
                break;

            case 1:


        }


    }

}
