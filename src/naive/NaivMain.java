package naive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NaivMain {
    /**
     * Алгоритм работает за O(m⋅(n−m)). В худшем случае m= n/2, что даёт O(n^2/4)=O(n^2).
     * Однако если m достаточно мало по сравнению с n,
     * то тогда асимптотика получается близкой к O(n),
     * поэтому этот алгоритм достаточно широко применяется на практике.
     * <p>
     * - Требует O(1) памяти.
     * - Приемлемое время работы на практике. Благодаря этом алгоритм применяется,
     * например, в браузерах и текстовых редакторах (при использовании Ctrl + F),
     * потому что обычно паттерн, который нужно найти, очень короткий по сравнению с самим текстом.
     * Также наивный алгоритм используется в стандартных библиотеках языков высокого уровня (C++, Java),
     * потому что он не требует дополнительной памяти.
     * - Простая и понятная реализация.
     */

    private static int compares = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter str: ");
        String str = scanner.nextLine();
        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();
        System.out.println("Position: " );
        List<Integer> r = naive(str,pattern);
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i)+" "+(r.get(i)+pattern.length()));
        }
        System.out.println("Compares count: " + compares);
    }

    private static List<Integer> naive(String str, String pattern) {
        List<Integer> result =new ArrayList<>();
        for (int i = 0; i < str.length() - pattern.length() +1; i++) {
            int res = compareStrings(str, pattern, i);
            if (res == pattern.length()) {
                result.add(i);
            }
        }
        return result;
    }

    static int compareStrings(String str, String pattern, int position) {
        if (position > str.length()) {
            return -1;
        } else {
            int i = 0;
            boolean flag = true;
            while (i < pattern.length() && flag) {

                if (str.charAt(position + i) == pattern.charAt(i)) {
                    compares++;
                    i++;
                } else {
                    compares++;
                    flag = false;
                }

            }
            return i;
        }
    }
}

