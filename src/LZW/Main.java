package LZW;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String to be Encoded: ");
        String toBeEncoded = scanner.nextLine();

        ArrayList<Integer> tags = Encoder.encode(toBeEncoded);

        for (Integer tag :
                tags) {
            System.out.print(tag);
            System.out.print(' ');
        }
        System.out.println();

        System.out.println(Decoder.decode(tags));
    }
}

/*
14
65 66 65 128 128 129 131 134 130 129 66 138 139 138
*/

/*
ABAABABBAABAABAAAABABBBBBBBB
ABAABABBAABAABAAAABABBBBBBBB
*/