package LZW;

import java.util.ArrayList;
import java.util.HashMap;

class Encoder {
    private static HashMap<String, Integer> dict = new HashMap<>();

    private static void __init_dict() {
        for (Integer i = 0; i <= 255; i++) {
            String ch = String.valueOf(((char)((int)i)));
            dict.put(ch, i);
        }
    }

    static ArrayList<Integer> encode(String input) {
        __init_dict();
        int start = 256;
        ArrayList<Integer> tags = new ArrayList<>();
        StringBuilder prev = new StringBuilder();
        StringBuilder currentVal = new StringBuilder();
        prev.append(input.charAt(0));
        for (int i = 0; i < input.length(); i++) {
            if (i != input.length() - 1)
                currentVal.append(input.charAt(i + 1));
            if (dict.containsKey(prev.toString() + currentVal.toString())) {
                prev.append(currentVal.toString());
            }
            else {
                tags.add(dict.get(prev.toString()));
                dict.put(prev.toString() + currentVal.toString(), start++);
                prev = currentVal;
            }
            currentVal = new StringBuilder();
        }
        tags.add(dict.get(prev.toString()));
        return tags;
    }
}
