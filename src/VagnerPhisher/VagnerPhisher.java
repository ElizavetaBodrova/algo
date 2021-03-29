package VagnerPhisher;


public class VagnerPhisher {
    public static int counter;

    public static void print(int[][] array){
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static int levenstain(String str1, String str2) {
        counter = 0;
        if (str1.length() == 0) {
            return str2.length();
        }
        if (str2.length() == 0) {
            return str1.length();
        }

        int priceDelete = 1;
        int pricePaste = 1;
        int[][] D = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            D[i][0] = D[i - 1][0] + 1;
            for (int j = 1; j < str2.length() + 1; j++) {
                D[0][j] = D[0][j - 1] + 1;
            }
        }
        System.out.print("D=");
        print(D);
        int check;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                counter++;
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    check = 0;
                }
                else {
                    check = 2;
                }
                D[i][j]=min(D[i-1][j]+priceDelete, D[i][j-1]+pricePaste, D[i-1][j-1]+check);

            }

        }
        System.out.print("D=");
        print(D);
        System.out.println("Расстояние между строками "+D[str1.length()][str2.length()]);

        int i = str1.length();
        int j = str2.length();
        System.out.println("След:");
        System.out.println("["+i+","+j+"]");
        while(i>1 && j>1){
            if(D[i-1][j-1]==D[i-2][j-1]+priceDelete){
                i--;
            }
            else{
                if(D[i-1][j-1]==D[i-1][j-2]+pricePaste){
                    j--;
                }
                else{
                    if(str1.charAt(i-2)==str2.charAt(j-2) && (i-1!=0 && j-1!=0)){
                        System.out.println("["+(i-1)+","+(j-1)+"]");
                        i--;
                        j--;
                    }
                }
            }
        }
        return D[str1.length()][str2.length()];
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}
