package common;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FractionCalculator {
    int numerator;  // 分子
    int denominator; // 分母

    FractionCalculator() {
    }

    FractionCalculator(int a, int b) {
        if (a == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            setNumeratorAndDenominator(a, b);
        }
    }

    void setNumeratorAndDenominator(int a, int b) {  // 设置分子和分母
        int c = f(Math.abs(a), Math.abs(b));         // 计算最大公约数
        numerator = a / c;
        denominator = b / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    int f(int a, int b) {  // 求a和b的最大公约数
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            ;
            r = a % b;
        }
        return b;
    }

    FractionCalculator add(FractionCalculator r) {  // 加法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        FractionCalculator result = new FractionCalculator(newNumerator, newDenominator);
        return result;
    }

    FractionCalculator sub(FractionCalculator r) {  // 减法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        FractionCalculator result = new FractionCalculator(newNumerator, newDenominator);
        return result;
    }

    FractionCalculator muti(FractionCalculator r) { // 乘法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        FractionCalculator result = new FractionCalculator(newNumerator, newDenominator);
        return result;
    }

    FractionCalculator div(FractionCalculator r) {  // 除法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        FractionCalculator result = new FractionCalculator(newNumerator, newDenominator);
        return result;
    }

    // 封装了具体运算，主要为对输入进行转换，对输出封装
    public static void compute(String data1, String operation, String data2) {
        StringTokenizer fenxi = new StringTokenizer(data1, "/");
        int data1_1 = Integer.parseInt(fenxi.nextToken());
        int data1_2 = Integer.parseInt(fenxi.nextToken());
        fenxi = new StringTokenizer(data2, "/");
        int data2_1 = Integer.parseInt(fenxi.nextToken());
        int data2_2 = Integer.parseInt(fenxi.nextToken());

        FractionCalculator r1 = new FractionCalculator(data1_1, data1_2);
        FractionCalculator r2 = new FractionCalculator(data2_1, data2_2);

        FractionCalculator result;
        int a, b;
        if (operation.equals("+")) {
            result = r1.add(r2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "/" + b);
        }

        if (operation.equals("-")) {
            result = r1.sub(r2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "/" + b);
        }

        if (operation.equals("*")) {
            result = r1.muti(r2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "/" + b);
        }

        if (operation.equals("/")) {
            result = r1.div(r2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "/" + b);
        }
    }

    public static void main(String[] args) {
        // 用户输入两分数和运算符
        Scanner input = new Scanner(System.in);
        System.out.println("请用户输入第一个分数(格式a/b)");
        String data1 = input.next();
        System.out.println("请用户输入要进行运算的运算符(+-*/)");
        String operation = input.next();
        System.out.println("请用户输入第二个分数(格式c/d)");
        String data2 = input.next();

        // 根据用户输入进行具体运算
        FractionCalculator cal = new FractionCalculator();
        System.out.println("运算结果为:");
        cal.compute(data1, operation, data2);
    }
}
