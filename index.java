// Code: SOS Alert System using GSM and Buzzer (Embedded C/C++)
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many random passwords do you want to generate?");
        int total = sc.nextInt();

        System.out.println("How many characters long do you want your random passwords to be?");
        int length = sc.nextInt();

        String[] randomPasswords = new String[total];

        for (int i = 0; i < total; i++) {
            String randomPassword = "";
            for (int j = 0; j < length; j++) {
                randomPassword += randomCharacter();
            }
            randomPasswords[i] = randomPassword;
        }

        printPasswords(randomPasswords);
        System.out.println("Password strength: " + getPasswordStrength(length));

        sc.close();
    }

    public static void printPasswords(String[] arr) {
        System.out.println("\nGenerated passwords:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static char randomCharacter() {
        int rand = (int) (Math.random() * 62); // 0–61 range
        if (rand < 10) {
            return (char) ('0' + rand); // digits 0–9
        } else if (rand < 36) {
            return (char) ('A' + (rand - 10)); // uppercase letters A–Z
        } else {
            return (char) ('a' + (rand - 36)); // lowercase letters a–z
        }
    }

    public static String getPasswordStrength(int length) {
        if (length <= 5) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}