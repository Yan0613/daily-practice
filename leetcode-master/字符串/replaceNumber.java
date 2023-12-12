import java.util.Scanner;

public class replaceNumber {
    public void replaceNumberSolution() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append("number");
            } else {
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
