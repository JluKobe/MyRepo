package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("d://test/b.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> list = new ArrayList<>();
        String str = null;
        while((str = br.readLine()) != null) {
            list.add(str);
        }

        Map<String, Integer> map = new HashMap<>();
        for(String s : list) {
            if(!map.containsKey(s)) {
                map.put(s, 1);
            }

            else {
                map.put(s, map.get(s) + 1);
            }
        }

        System.out.println(map.keySet().size());

        br.close();
        fr.close();
    }
}
