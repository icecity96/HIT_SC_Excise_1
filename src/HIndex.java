import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int[] citations = new int[100];
        List<Integer> citations = new ArrayList<>();

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
                Integer value = Integer.parseInt(strs[i]);
                citations.add(value);
            }
            if (legalNumbers) {
                break;
            }
        }

        int hindex = hindex(citations);

        System.out.println("The h-index is: " + hindex);
    }

    public static int hindex(List<Integer> citations) {

        citations.sort(Collections.reverseOrder());

        // calculate h-index
        int hindex = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                hindex = i + 1;
            } else {
                break;
            }
        }
        return hindex;
    }
}
