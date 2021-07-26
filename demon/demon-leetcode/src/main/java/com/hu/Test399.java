package com.hu;

import java.util.*;

/**
 * @author hudelin
 * @date 2021/1/6
 */
public class Test399 {

    /**
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
     *  
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     */

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>() {{
            add(Arrays.asList("a", "b"));
            add(Arrays.asList("e", "f"));
            add(Arrays.asList("b", "e"));
        }};
        double[] values = {3.4, 1.4, 2.3};
        List<List<String>> queries = new ArrayList<>() {{
            add(Arrays.asList("b", "a"));
            add(Arrays.asList("a", "f"));
            add(Arrays.asList("f", "f"));
            add(Arrays.asList("e", "e"));
            add(Arrays.asList("c", "c"));
            add(Arrays.asList("a", "c"));
            add(Arrays.asList("f", "e"));
        }};
        double[] doubles = calcEquation(equations, values, queries);
        for (double v : doubles) {
            System.out.println(v);
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        Map<String, Double> map = new HashMap<>();
        if (equations != null && equations.size() > 0) {
            List<String> eq = equations.get(0);
            if (eq != null && eq.size() > 0) {
                map.putIfAbsent(eq.get(0), 3.00000);
            }
        }
        List<Map<String, Double>> mapList=new ArrayList<>();
        mapList.add(map);
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String one = eq.get(0);
            String two = eq.get(1);
            double value = values[i];
            Map<String, Double> newMap = null;
            for (Map<String, Double> m : mapList) {
                if (m.get(one) != null) {
                    m.putIfAbsent(two, m.get(one) / value);
                } else if (m.get(two) != null) {
                    m.putIfAbsent(one, m.get(two) * value);
                }else{
                    newMap = new HashMap<>();
                }
            }

        }
        return result;
    }


}
