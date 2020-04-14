package com.lewis.helloworld;

import java.util.Scanner;

public class HuaWeiStringTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            if (scan.hasNextDouble()){
                double input = scan.nextDouble();
                System.out.println((int) Math.round(input));
            }

        }
        scan.close();
    }




    //取近似值
    private void mathRound(){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            if (scan.hasNextDouble()){
                double input = scan.nextDouble();
                System.out.println((int) Math.round(input));
            }

        }
        scan.close();
    }


    //质数因子
    public String getResult(long ulDataInput) {

        StringBuilder sb = new StringBuilder();
        int index = 2;
        while (ulDataInput >= index) {
            if (ulDataInput % index == 0) {
                ulDataInput = ulDataInput / index;
                sb.append(index).append(" ");
            } else {
                index++;
            }
        }


        return sb.toString();
    }

    //16转10,需要考虑数字大小，输出10进制字符串
    private static void _16to10() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String s = scan.next();
            double result = 0;
            int length = s.length();
            for (int i = 2; i < length; i++) {
                if (s.charAt(i) == 'A') {
                    result += 10 * Math.pow(16, length - i - 1);
                } else if (s.charAt(i) == 'B') {
                    result += 11 * Math.pow(16, length - i - 1);
                } else if (s.charAt(i) == 'C') {
                    result += 12 * Math.pow(16, length - i - 1);
                } else if (s.charAt(i) == 'D') {
                    result += 13 * Math.pow(16, length - i - 1);
                } else if (s.charAt(i) == 'E') {
                    result += 14 * Math.pow(16, length - i - 1);
                } else if (s.charAt(i) == 'F') {
                    result += 15 * Math.pow(16, length - i - 1);
                } else {
                    //数字0的ascall是48
                    result += (s.charAt(i) - 48) * Math.pow(16, length - i - 1);

                }
            }

            System.out.println(((int) result));


        }
        scan.close();
    }


    //字符串分割
    private static void stringSpilt() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            StringBuilder sb = new StringBuilder();
            String s = scan.next();
            if (s.length() < 8) {
                sb.append(s);
                for (int i = 0; i < 8 - s.length(); i++) {
                    sb.append("0");
                }
                System.out.println(sb.toString());
            } else if (s.length() == 8) {
                System.out.println(s);
            } else {
                int splitCount = s.length() / 8;
                int lef = s.length() % 8;
                for (int i = 0; i < splitCount; i++) {
                    System.out.println(s.substring(i * 8, (i + 1) * 8));
                }
                if (lef > 0) {
                    sb.append(s.substring(splitCount * 8, s.length()));
                    for (int i = 0; i < 8 - lef; i++) {
                        sb.append("0");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
        scan.close();

    }


    //输入多行数据，排序+去重
    private static void printMulLine() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int param[] = new int[1001];
            int n = scan.nextInt();
            while (n > 0) {
                int k = scan.nextInt();
                param[k] = 1;
                n -= 1;
            }
            for (int i = 0; i < 1001; i++) {
                if (param[i] == 1) {
                    System.out.println(i);
                }
            }

        }
    }


    //输入重复的个数
    private static int getRepeatCount(String str) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String lineOne = scan.nextLine();
            String lineTwo = scan.nextLine();
            int count = 0;

            for (int i = 0; i < lineOne.length(); i++) {
                if (lineTwo.equalsIgnoreCase(String.valueOf(lineOne.charAt(i)))) {
                    count++;
                }
            }

            System.out.println(count);
        }
        return 0;
    }


    //一行字符串，非空，长度小于5000。
    //空格区分，输出左最后一个单词的长度
    private static int getLastWorldLength(String str) {
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        int last = length - 1;
        int lastWorldLength = 0;


        while (last >= 0 && str.charAt(last) != 32) {
            lastWorldLength++;
            last--;
        }

        return lastWorldLength;
    }


}
