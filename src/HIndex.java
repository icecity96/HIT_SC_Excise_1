import java.util.Scanner;

public class HIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] citations = new int[100];
        String[] strs;
        System.out.println("Please input the citation numbers:");
        String line = scanner.nextLine();
        strs = line.split(",");
        for (int i = 0; i < strs.length; i++) {
            citations[i] = Integer.parseInt(strs[i]);
        }

        int hindex = hindex(citations);

        System.out.println("The h-index is: " + hindex);
    }

    public static int hindex(int[] citations) {
        // bubble sorting
        sort(citations);

        // calculate h-index
        int hindex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1) {
                hindex = i + 1;
            } else {
                break;
            }
        }
        return hindex;
    }

    private static void sort(int[] array) {
        int number = array.length;
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (array[j] < array[j+1] ) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
