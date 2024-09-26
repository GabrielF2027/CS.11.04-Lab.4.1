public class Main {
    public static void main(String[] args) {
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(reverseInteger(1234));
        System.out.println(encryptThis("Hello good day"));
        System.out.println(decipherThis("72olle 103doo 100ya"));
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
        }
        return (openCount == closeCount) && (str.charAt(0) == '(') && (str.charAt(str.length() - 1) == ')');
    }

    // 2. reverseInteger
    public static String reverseInteger(int integer) {
        String str = Integer.toString(integer);
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str2 += str.charAt(i);
        }
        return str2;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        String[] words = str.split(" ");
        String encryptedWord = "";
        String encryptedStr = "";
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    encryptedWord += (int) word.charAt(0);
                } else if (i == 1) {
                    encryptedWord += word.charAt(word.length() - 1);
                } else if (i == word.length() - 1) {
                    encryptedWord += word.charAt(1);
                } else {
                    encryptedWord += word.charAt(i);
                }
            }
            encryptedWord += " ";
            encryptedStr += encryptedWord;
            encryptedWord = "";
        }
        return encryptedStr;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String[] words = str.split(" ");
        String decipheredWord = "";
        String decipheredStr = "";
        String firstLetterNo = "";
        int firstLetterNoIndex = 0;
        char firstLetter;
        for (String word : words) {
            for (int i = 0; Character.isDigit(word.charAt(i)); i++) {
                firstLetterNoIndex = i;
            }
            firstLetterNo = word.substring(0, firstLetterNoIndex+1);
            firstLetter = (char) Integer.parseInt(firstLetterNo);
            decipheredWord += firstLetter;
            firstLetterNo = "";
            for (int i = firstLetterNoIndex+1; i < word.length(); i++) {
                if(i == firstLetterNoIndex+1) {
                    decipheredWord += word.charAt(word.length()-1);
                }
                else if(i == word.length()-1) {
                    decipheredWord += word.charAt(firstLetterNoIndex+1);
                }
                else {
                    decipheredWord += word.charAt(i);
                }
            }
            decipheredWord += " ";
            decipheredStr += decipheredWord;
            decipheredWord = "";
        }
        return decipheredStr;
    }
}