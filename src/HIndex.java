import java.util.*;

public class HIndex {

    private List<Integer> citations = new ArrayList<>();

    public HIndex(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty");
        }
        dealInput(input);
    }

    private void dealInput(String input) {
        String[] strs = input.split(",");
        for (int i = 0; i < strs.length; i++) {
            // if not, stop checking others and let user re-input.
            if (! strs[i].matches("[0-9]+")) {
                throw new IllegalArgumentException(strs[i] + " is illegal");
            }
            Integer value = Integer.parseInt(strs[i]);
            citations.add(value);
        }
    }

    public int calcHIndex() {
        return hindex(citations);
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"1,0", "3,2,4,8"};

        for (String input: inputs) {
            HIndex h = new HIndex(input);
            System.out.println(h.calcHIndex());
        }
    }
    public int hindex(List<Integer> citations) {

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
