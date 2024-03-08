import java.util.Scanner;

public class HIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] citations = new int[100];
        String[] strs;
        System.out.println("Please input the citation numbers:");

        // loop, until user inputs legal string
        while (true) {
            String line = scanner.nextLine();
            // if the input is empty.
            while (line.isEmpty()) {
                System.out.println("Input is empty, please re-input:");
                line = scanner.nextLine();
            }

            // check if each part is non-negative integer
            boolean legalNumbers = true;
            strs = line.split(",");
            for (int i = 0; i < strs.length; i++) {
                // if not, stop checking others and let user re-input.
                if (! strs[i].matches("[0-9]+")) {
                    System.out.println(strs[i] + " is illegal, please re-input:");
                    legalNumbers = false;
                    break;
                }
                citations[i] = Integer.parseInt(strs[i]);
            }
            if (legalNumbers) {
                break;
            }
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
