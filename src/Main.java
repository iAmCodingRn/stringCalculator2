

import java.util.InputMismatchException;
import java.util.Scanner;
//������: ��������� "��������� �����������"
//        ��������:
//        �������� ���������� ���������� "��������� �����������".
//        ���������� ������ ������ �� ������� ��������� ������������� ������, �����, �������������� �������� ���������� ����� ���� � �������� � �������
//        ��������� �� ����������.
//
//        ����������:
//        ����������� ����� ��������� �������� �������� �����, ��������� ������ �� ������, ��������� ������ �� ����� � ������� ������ �� �����:
//        "a" + "b", "a" - "b", "a" * b, "a" / b. ������ ���������� � ���� ������(�������� ������)! �������, � ������� ������ ������,
//        ����� � �������������� �������� ���������� � ����� ������ ��������� ���������.
//        �������� ����� ������������ � ��������� ���������� �������� ���������.
//        ����������� �������� ���� �����, �������� ������ ��������� �� ����������
//        ����������� ������� ������ �� ����� n, �������� ������ � n ��� ������ �������� (�������� ������)
//        ����������� ��������� ������ �� ����� n, �������� ������, � ������� ���������� ������ ����������� ����� n ���
//        ����������� ��������� ������ �� ������, �������� ������ � ������� ������� ���������� ��������� ��� �������� ������,
//        ���� � ��� ��� ��������� ���������� ������
//        ����������� ������ ��������� �� ���� ����� �� 1 �� 10 ������������, �� �����. � ������ ������� �� ����� 10 ��������.
//        ���� ������, ���������� � ���������� ������ ���������� ������ 40 ��������, �� � ������ ����� 40 ������� ������ ������ ��� ����� (...)
//        ����������� ����� �������� ������ � ������ �������.
//        ������ ���������� ���������, ����������� �� ����, ������ ���� ������, ��� ����� ������������� ��������� ����� 3 + "hello",
//        ����������� ������ ��������� ���������� � ���������� ���� ������.
//        ��� ����� ������������� ������������ �����, ����� ��� ���������������� �������� (��������, ������� ������ �� ������) ����������
//        ����������� ���������� � ��������� ���� ������.
//        ��� ����� ������������� ��������� �� ���������������� ����� �� ������������� �������������� �������� ���������� ����������� ���������� �
//        ��������� ���� ������.
//        ������ ������ ���������:
//        Input:
//        "100" + "200"
//
//        Output:
//        "100200"
//
//        Input:
//        "Hello World!" - "World!"
//
//        Output:
//        "Hello "
//
//        Input:
//        "Hi" * 5
//
//        Output:
//        "HiHiHiHiHi"
//
//        Input:
//        "Example Text!!!" / 3
//
//        Output:
//        "Exam"

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result = "";

    private static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void main(String[] args) {
        while (true) {
            result = "";
            System.out.println("������� ��������� [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] ��� a � b - ������ ������ �� ����� " +
                    "10 �������� � x - �����  �� 1 �� 10 ������������  + [Enter] ��� " +
                    " [exit] ��� ������");

            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                exit();
            }
            char[] uchar = new char[26];
            for (int i = 0; i < userInput.length(); i++) {
                uchar[i] = userInput.charAt(i);
                if (uchar[i] == '+') {
                    operation = '+';
                }
                if (uchar[i] == '-') {
                    operation = '-';
                }
                if (uchar[i] == '*') {
                    operation = '*';
                }
                if (uchar[i] == '/') {
                    operation = '/';
                }
            }

            String[] blocks = userInput.split("[+-/*\"]");

            if (blocks.length == 5) {
                String st00 = blocks[0];
                String st01 = blocks[1];
                String st04 = blocks[4];
                result = calculated(st01, st04, operation);
                if (result.length() > 40) {
                    String rez = result.substring(0, 40);
                    System.out.println(rez + "...");
                } else {
                    System.out.println(result);
                }
            } else {
                String st01 = blocks[1];
                String st03 = null;
                try {
                    st03 = blocks[3];
                } catch (ArrayIndexOutOfBoundsException e) {


                    System.out.println("�������� ������ ������");
                }
                try {
                    number = Integer.parseInt(st03);
                    result = calculated(st01, number, operation);
                } catch (NumberFormatException e) {

                    System.out.println("�������� ������ ������");
                }

                if (result.length() > 40) {
                    String rez = result.substring(0, 40);
                    System.out.println(rez + "...");
                } else {
                    System.out.println(result);
                }
            }
        }
    }


    public static String calculated(String num1, String num2, char op) {
        if (num1.length()>10){
            throw new StringIndexOutOfBoundsException();
        }
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                boolean cb = num1.contains(num2);
                if (cb) {
                    int resA = num1.length() - num2.length();
                    result = num1.substring(0, resA);
                } else {
                    result = num1;
                }
                if (cb & num1.length() == num2.length()) {
                    result = "0";
                }
                break;
            case '*':
                System.out.println("�������� ���� �������� * (������� + ��� -)");
                break;
            case '/':
                System.out.println("�������� ���� �������� / (������� + ��� -)");
                break;
            default:
                throw new IllegalArgumentException("�� ������ ���� ��������");
        }
        return result;
    }

    public static String calculated(String num1, int num, char op) {
        if ( num>10){
            throw new InputMismatchException("����� ������ 10");
        }
        if(num1.length()>10){
            throw new InputMismatchException("������ ������ 10 ������");
        }
        switch (op) {
            case '+':
                System.out.println("�������� ���� �������� + (������� * ��� /)");

                break;
            case '-':
                System.out.println("�������� ���� �������� - (������� * ��� /)");
                break;
            case '*':
                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }

                break;
//
            case '/':
                try {
                    int resB = num1.length() / num;
                    if (num1.length() == num) {
                        result = "1";
                    } else {
                        result = num1.substring(0, resB);
                    }
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("������� ������ ��������");
                    }
                }
//
                break;
            default:
                throw new IllegalArgumentException("�� ������ ���� ��������");
        }
        return result;
    }
}
