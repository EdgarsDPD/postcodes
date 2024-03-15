package edgars.postcodes.generateList;

import java.util.ArrayList;
import java.util.List;

public class GeneratePostcode {

    public static List<String> generatePostcodes(String[] postCodeRange) {
        String startPostcode = postCodeRange[0];
        String endPostcode = (postCodeRange.length > 1) ? postCodeRange[1] : "";

        List<String> generatedPostcodes = new ArrayList<>();
        generatedPostcodes.add(startPostcode);

        while(!endPostcode.isEmpty() && !startPostcode.equals(endPostcode)) {
            startPostcode = generateNextPostcode(startPostcode);
            generatedPostcodes.add(startPostcode);
        }
        return generatedPostcodes;
    }

    // private static List<String> generatePostcodesInRange(String start, String end) {
    //     List<String> postcodes = new ArrayList<>();
    //     char startPostcodeLastChar = start.charAt(start.length() - 1);
    //     char endPostcodeLastChar = end.length() > 0 ? end.charAt(end.length() - 1) : startPostcodeLastChar;

    //     while (true) {
    //         postcodes.add(start);
    //         if (start.equals(end)) {
    //             break;
    //         }

    //         start = generateNextPostcode(start);
    //         if (start.charAt(start.length() - 1) > endPostcodeLastChar) {
    //             break;
    //         }
    //     }
    //     return postcodes;
    // }

    private static String generateNextPostcode(String currentPostcode) {
        char[] chars = currentPostcode.toCharArray();

        // incrament last char of postcode
        char lastChar = chars[chars.length - 1];
        if (Character.isDigit(lastChar)) {
            // if it is digit, increment it
            if (lastChar == '9') {
                // if it is 9, carry over to the previous character
                for (int i = chars.length - 2; i >= 0; i--) {
                    if (Character.isLetter(chars[i])) {
                        chars[i]++; // increment the letter
                        break;
                    }
                }
                chars[chars.length - 1] = '0'; // Reset the last digit to 0
            } else {
                // increment the digit
                chars[chars.length - 1]++;
            }
        } else {
            // if it is a letter, increment it
            if (lastChar == 'Z') {
                // if it is a Z, carry over to the previous character
                for (int i = chars.length - 2; i >= 0; i--) {
                    if (Character.isLetter(chars[i])) {
                        if (chars[i] == 'Z') {
                            chars[i] = 'A'; // Reset Z to A
                        } else {
                            chars[i]++; // Increment the letter
                        }
                        break;
                    }
                }
                chars[chars.length - 1] = 'A'; // Reset the last letter to A
            } else {
                // increment letter
                chars[chars.length - 1]++;
            }
        }
        return new String(chars);
    }
}
