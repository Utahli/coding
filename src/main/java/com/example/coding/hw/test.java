package com.example.coding.hw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author liqingtai
 * @date 2020-03-28
 */
public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        List<String> str = new ArrayList<>();
        while (count>0) {
            str.add(in.nextLine());
            count--;
        }

        str.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return comp(o1, o2);
            }
        });

        str.forEach(e-> System.out.println(e));

    }


    public static int comp(String p, String q) {
        double pg = changToG(p);
        double qg = changToG(q);
        return pg > qg ? 0 : 1;
    }

    public static double changToG(String str) {
        double num = Double.parseDouble(str.substring(0, str.length() - 1));
        if (str.endsWith("G")) {
            return num;
        }
        if (str.endsWith("T")) {
            return 1000 * num;
        }
        if (str.endsWith("M")) {
            return num / 1000;
        }
        return 0;
    }
}
