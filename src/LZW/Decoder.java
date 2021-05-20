package LZW;

import java.util.ArrayList;
import java.util.HashMap;

class Decoder {

    private static HashMap<Integer, String> dict = new HashMap<>();

    private static void __init_dict() {
        for (Integer i = 0; i <= 255; i++) {
            String ch = String.valueOf(((char)((int)i)));
            dict.put(i, ch);
        }
    }

    static String decode(ArrayList<Integer> tags) {
        __init_dict();
        int start = 256;
        StringBuilder out = new StringBuilder();
        String prev = "";
        String currentVal;
        Integer currentTag;
        for(int i = 0; i < tags.size(); i++) {
            currentTag = tags.get(i);
            if(dict.containsKey(currentTag)) {
                currentVal = dict.get(currentTag);
                if(i > 0) dict.put(start++, prev + currentVal.charAt(0));
            }
            else {
                currentVal = prev + prev.charAt(0);
                dict.put(currentTag, currentVal);
            }
            out.append(currentVal);
            prev = currentVal;
        }

        return out.toString();
    }
}
