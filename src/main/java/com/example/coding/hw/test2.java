package com.example.coding.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liqingtai
 * @date 2020-03-28
 */
public class test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<String> lines = new ArrayList<>();
        while (!line.equals("")) {
            lines.add(line);
            line = in.nextLine();
        }

        List<Boolean> res = new ArrayList<>();

        lines.forEach(e->{
            String[] split = e.split(" ");
            int length = split.length;

            boolean jishu = length % 2 == 1;
            if (jishu) {
                if (split[0].length() != split[length - 1].length()) {
                    res.add(false);
                    return;
                }


            }
        });

    }

}
