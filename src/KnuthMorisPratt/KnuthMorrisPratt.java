package KnuthMorisPratt;

public class KnuthMorrisPratt {
    private static int compares = 0;

    public static int getCompares() {
        return compares;
    }

    public static void findKnuthMorrisPratt(String s, String pattern) {
        int[] betta_ = findBorderArrayVariant(pattern);
        int i = 0;
        int j = 0;
        int sLength = s.length();
        int patternLength = pattern.length();
        while (i <= sLength - patternLength + j/* + 1*/) {
            int[] i_j = match(s, pattern, i, j);
            i = i_j[0];
            j = i_j[1];
            if (j == patternLength) {
                System.out.println("["+(i - patternLength)+","+ (i-1)+"]");
                j = betta_[j] ;


            }
            if (j == 0) {
                i++;
            } else {
                j = betta_[j]-1;
            }
        }
    }

    private static int[] match(String str, String pattern, int i, int j) {
        while (i>=0 && j>=0 && i < str.length() && j < pattern.length() && str.charAt(i) == pattern.charAt(j)) {
            compares++;
            j++;
            i++;
        }
        if(i!=str.length())compares++;
        return new int[]{i, j};
    }

    public static int[] findBorderArrayVariant(String s) {
        int length = s.length();
        int[] betta = betta(s);
        int[] bettaVariation = new int[length + 1];
        bettaVariation[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            bettaVariation[i] = betta[i - 1] + 1;
        }
        System.out.print("b'= ");
        for (int i =0; i < length ; i++){
            System.out.print(betta[i]+" ");
        }
        System.out.println();
        return bettaVariation;
    }


    public static int[] betta(String s) {
        int length = s.length();
        int[] betta = new int[length];
        betta[0] = 0;
        for (int i = 1; i < length; i++) {
            int b = betta[i - 1];
            while (b > 0 && s.charAt(i) != s.charAt(b)) {
                b = betta[b - 1];
            }
            if (s.charAt(i) == s.charAt(b)) {
                betta[i] = b + 1;
            } else {
                betta[i] = 0;
            }
        }
        return betta;
    }
}
