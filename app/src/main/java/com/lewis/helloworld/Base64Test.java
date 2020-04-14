package com.lewis.helloworld;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Base64Test {


    /**
     * 总结：
     * 1. 需要   Scanner scan = new Scanner(System.in); 输入输出函数
     * 2. 需要添加依赖包 import java.util.*;
     * 3. 需要注意边界值，数组越界等问题
     * @param args
     */
    public static void main(String[] args) {


        Base64Test base64Test = new Base64Test();

        int[] rec1  = new int[]{0,0,1,1};
        int[] rec2 = new int[]{1,0,2,1};


        System.out.println(base64Test.isRectangleOverlap(rec1, rec2));

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec2[0] < rec1[2] && rec2[2] > rec1[0] && rec2[1] < rec1[3] && rec2[2] > rec1[1] ){
            return true;
        }

        return false;
    }

    public int countCharacters(String[] words, String chars) {

        int result = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            String temp  = chars;


            for (int j = 0; j < word.length(); j++) {
                temp = temp.replaceFirst(String.valueOf(word.charAt(j)),"");
                //如果最后一次result的长度为chars.length-word.length，则此单词已掌握
                if (j == word.length() -1){
                    if ((chars.length() - word.length()) == temp.length()){
                        result = result +  word.length();
                    }
                }
            }
        }

        return result;
    }

    //斐波那契
    public static List<Integer> fibonacci(int n) {
        // Write your code here
        if (n == 1){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 1;
        int temp = 0;
        result.add(i);
        result.add(j);

        for (int k = 0; k < n-2; k++) {
            temp = i+j;
            i = j;
            j = temp;

            result.add(temp);
        }


        return result;
    }


    //因式分解，如果是支书，返回1，如果不是，返回最小的质数
    public static int isPrime(long n) {
        // Write your code here
        long s = (long) Math.sqrt(n);

        for (int i = 2; i <= s ; i++) {
            if (n % i == 0){
                return i;
            }
        }

        return 1;
    }




    public static void fizzBuzz(int n) {
        // Write your code here
        //3&5 FizzBuzz
        //3 ~5 Fizz
        //~3 5 Buzz
        //~3 ~5 i
        for (int i = 1; i <=n ; i++) {
            if (i%3 == 0 && i %5 == 0){
                System.out.println("FizzBuzz");
            }else if (i%3 == 0){
                System.out.println("Fizz");
            }else if (i %5 == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }


}
