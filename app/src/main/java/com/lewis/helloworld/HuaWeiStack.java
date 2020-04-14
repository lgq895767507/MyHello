package com.lewis.helloworld;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class HuaWeiStack {


    public static void main(String[] args) {

        HuaWeiStack huaWeiStack = new HuaWeiStack();
        huaWeiStack.getCatStr();

    }

    //一顿段英文字符串，英文文字cat，找到cat 下表，return int[]
    private void getCatStr() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            ArrayList<Integer> result = new ArrayList<>();
            String inputString = scanner.nextLine();  //输入的内容
            if (inputString.length() < 3) {
                System.out.println("没有找到内容");
                return;
            }

            int catAscall = 'c' + 'a' + 't';
            int CatAscall = 'C' + 'a' + 't';
            int cAtAscall = 'c' + 'A' + 't';
            int caTAscall = 'c' + 'a' + 'T';
            int CAtAscall = 'C' + 'A' + 't';
            int CaTAscall = 'C' + 'a' + 'T';
            int cATAscall = 'c' + 'A' + 'T';
            int CATAscall = 'C' + 'A' + 'T';

            //第一次计算前三个
            int temp = inputString.charAt(0) + inputString.charAt(1) + inputString.charAt(2);
            if (temp == catAscall ||
                    temp == CatAscall ||
                    temp == cAtAscall ||
                    temp == caTAscall ||
                    temp == CAtAscall ||
                    temp == CaTAscall ||
                    temp == cATAscall ||
                    temp == CATAscall) {
                catCompare(result, 2, inputString);
            }

            for (int i = 3; i < inputString.length(); i++) {
                //下一次计算,减去上一个，加上下一个
                temp = temp - inputString.charAt(i - 3) + inputString.charAt(i);
                if (temp == catAscall ||
                        temp == CatAscall ||
                        temp == cAtAscall ||
                        temp == caTAscall ||
                        temp == CAtAscall ||
                        temp == CaTAscall ||
                        temp == cATAscall ||
                        temp == CATAscall) {
                    catCompare(result, i, inputString);
                }
            }

            System.out.println(result);
        }
        scanner.close();
    }

    private void catCompare(ArrayList<Integer> result, int i, String inputString) {
        //如果ascall值相等，就比较下是否每个单词相等
        if (inputString.substring(i - 2, i + 1).equalsIgnoreCase("cat")) {
            result.add(i - 2);
        }
    }


    //找出多数元素
    public int majorityElement(int[] nums) {
        //1排序，2/n 就是该元素
        //插入排序
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入到a[i-1], a[i-2],...
            for (int j = i; j > 0 && (nums[j] < nums[j - 1]); j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }

        }

        return nums[N / 2];
    }


    //文件处理
    private void file() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String messageLine = null;
        //使用有序的LinkedHashMap存储信息
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        //循环读入数据
        while ((messageLine = bufferedReader.readLine()) != null) {
            String[] error_Message = messageLine.split(" ");
            String error = error_Message[0];
            String line_no = error_Message[1];
            //取文件名
            String file_Name = error.substring(error.lastIndexOf("\\") + 1);
            //处理长度超过16的情况
            if (file_Name.length() > 16) {
                file_Name = file_Name.substring(file_Name.length() - 16);
            }

            //将错误信息添加到map中
            String error_Name = file_Name + " " + line_no;
            if (map.containsKey(error_Name)) {
                map.put(error_Name, map.get(error_Name) + 1);
            } else {
                map.put(error_Name, 1);
            }
        }

        //输出错误信息,最多8条(后八条)
        int count = 0;
        for (String key : map.keySet()) {
            count++;
            if (count > (map.size() - 8))
                System.out.println(key + " " + map.get(key));
        }
    }

    //背包问题
    private void bag() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
            int N = Integer.parseInt(str.split(" ")[0]) / 10;
            int m = Integer.parseInt(str.split(" ")[1]);
            int[] v = new int[m + 1];
            int[] p = new int[m + 1];
            int[] q = new int[m + 1];
            boolean[] flags = new boolean[m + 1];
            int[][] res = new int[m + 1][N + 1];
            for (int i = 1; i <= m; i++) {
                String[] strings = br.readLine().split(" ");
                v[i] = (Integer.parseInt(strings[0])) / 10;
                p[i] = Integer.parseInt(strings[1]) * v[i];
                q[i] = Integer.parseInt(strings[2]);
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= N; j++) {
                    if (q[i] == 0) {
                        if (v[i] <= j) {
                            res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - v[i]] + p[i]);
                        }
                    } else {
                        if (v[i] + v[q[i]] <= j) {
                            res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - v[i]] + p[i]);
                        }
                    }
                }
            }
            System.out.println(res[m][N] * 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转2进制，求1的个数
    private void get2Count() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                int count = 0;
                while (value > 0) {
                    if ((value & 1) > 0) {
                        count++;
                    }
                    value = value >> 1;
                }
                System.out.println(count);

            }

        }


        scanner.close();
    }


    //字典排序
    //双向链表的数据结构挺合适的
    //1. 存，2.排序 3.输出
    private void zidian() {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();

        while (count > 0 && scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            arrayList.add(temp);
            count--;
        }

        //输出
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


        scanner.close();
    }


    //句子逆序
    public String reverse(String sentence) {
        String[] split = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = (split.length - 1); i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        return sb.toString();
    }

    //字符串颠倒
    private static void stringDao() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //字符串颠倒
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = (line.length() - 1); i >= 0; i--) {
                sb.append(line.charAt(i));
            }
            System.out.println(sb.toString());
        }


        scanner.close();
    }


    //输入N个字符，字符在ACSII码范围内。
    //输出范围在(0~127)字符的个数。
    //计算字符串中含有的不同字符的个数
    private static void getCount() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int count = 0;
            int[] array = new int[128];
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) > 0 && line.charAt(i) - 127 < 0) {
                    array[line.charAt(i)]++;
                }
            }


            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    count++;
                }
            }
            System.out.println(count);
        }


        scanner.close();
    }


    //提取不重复的数,考察点，自己创建一个容器
    private static void noRepeat() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            if (line.length() == 0) {
                System.out.println("输入不合法");
                return;
            }
            int[] stand = new int[10];
            StringBuilder sb = new StringBuilder();
            for (int i = (line.length() - 1); i >= 0; i--) {
                if (stand[line.charAt(i) - 48] == 0) {
                    stand[line.charAt(i) - 48]++;
                    sb.append(line.charAt(i));
                }
            }
            System.out.println(sb.toString());

        }


        scanner.close();
    }


    //合并记录表
    //先输入键值对的个数
    //然后输入成对的index和value值，以空格隔开
    private static void hebing() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int count = Integer.parseInt(scanner.nextLine());
                Map<Integer, Integer> map = new TreeMap<>();

                for (int i = 0; i < count; i++) {

                    String line = scanner.nextLine();
                    String[] split = line.split("\\s+");//正则表达式\s表示匹配任何空白字符，+表示匹配一次或多次

                    addMap(map, split);
                }
                printMap(map);
            }
        }
        scanner.close();
    }

    private static void printMap(Map<Integer, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entity : map.entrySet()) {
            sb.append(entity.getKey()).append(" ").append(entity.getValue()).append("\r");
        }
        System.out.println(sb.toString());
    }

    private static void addMap(Map<Integer, Integer> map, String[] split) {
        int key = Integer.parseInt(split[0]);
        int value = Integer.parseInt(split[1]);
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }


}
