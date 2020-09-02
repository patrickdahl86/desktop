package patrick;

import java.util.Scanner;

public class Main {

    public enum PasswordValidation {
        password_too_short,
        password_not_just_letters_or_digits,
        password_too_few_digits,
        password_all_ok
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lag et nytt passord");
        String inputString = input.nextLine().toLowerCase();

        int numberOfDigitsReq = 3;
        PasswordValidation isValidPassword = validatePassword(inputString, 10, numberOfDigitsReq);

        switch(isValidPassword) {

            case password_too_short:
                System.out.println("Passord for kort");
                break;

            case password_not_just_letters_or_digits:
                System.out.println("Passordet kan kun innholde tall eller bokstaver");
                break;

            case password_too_few_digits:
                System.out.println("Det må være minst " + numberOfDigitsReq + " tall i passordet ditt.");
                break;

            case password_all_ok:
                System.out.println("Godkjent passord");
                break;

        }

    }

    public static PasswordValidation validatePassword(String userInput, int numberOfChars, int reqNumberOfDigits) {

        boolean validLength = userInput.length() >= numberOfChars;
        if (!validLength) {
            return PasswordValidation.password_too_short;
        }

        int numberOfDigits = 0;
        char charFromString;
        for (int i = 0; i < userInput.length(); i++) {

            charFromString = userInput.charAt(i);
            if (Character.isDigit(charFromString)) {
                numberOfDigits++;
            }

            if (!Character.isLetterOrDigit(charFromString)) {
                return PasswordValidation.password_not_just_letters_or_digits;
            }

        }

        if (!(numberOfDigits >= reqNumberOfDigits)) {
            return PasswordValidation.password_too_few_digits;
        }

        return PasswordValidation.password_all_ok;

    }


}
