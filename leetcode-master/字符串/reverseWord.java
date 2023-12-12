import java.util.Scanner;

public class reverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            String strTemp = reverseWord(strArr[i]);
            if (i == strArr.length - 1) {
                sb.append(strTemp);
            } else {
                sb.append(strTemp + " ");
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }

    private static String reverseWord(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = c;
        }
        return new String(arr);
    }
}
