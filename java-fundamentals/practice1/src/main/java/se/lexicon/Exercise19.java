package se.lexicon;

public class Exercise19 {
    public static void main(String[] args) {
        System.out.println("countVowels(\"Hello World\") = " + countVowels("Hello World"));
        System.out.println("countVowels(\"Java\") = " + countVowels("Java"));
        System.out.println("countVowels(\"rhythm\") = " + countVowels("rhythm"));
    }

    public static int countVowels(String s) {
        s = s.toLowerCase();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ("aeiou".indexOf(ch) >= 0) {
                count++;
            }
        }

        return count;
    }
}
