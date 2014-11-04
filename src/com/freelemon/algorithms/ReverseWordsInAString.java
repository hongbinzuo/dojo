package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/25/14
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        String result = r.reverseWords(" This    is a    test!    ");

        System.out.println(result);

    }

    public String reverseWords(String s) {
        char[] cOldStr = s.trim().toCharArray();
        char[] cStr = new char[cOldStr.length];
        int flag = 0;
        int index = 0;

        for (int i = 0; i < cOldStr.length; i++) {
            if (cOldStr[i] == ' ') {
                flag++;
                if (flag == 1) {
                    cStr[index++] = cOldStr[i];
                } else {
                    continue;
                }
            } else {
                flag = 0;
                cStr[index++] = cOldStr[i];
            }
        }

        char[] test = String.valueOf(cStr).trim().toCharArray();


        int i = 0, j = 0;
        while (i < test.length) {
            if (test[i] == ' ') {
                reverse(test, j, i - 1);
                j = i + 1;
            }
            i++;
        }

        reverse(test, j, i - 1);

        reverse(test, 0, test.length - 1);


        return String.valueOf(test).trim();

    }

    private void reverse(char[] cStr, int p, int q) {
        if (null == cStr) return;

        char c;

        while (p < q) {
            c = cStr[p];
            cStr[p] = cStr[q];
            cStr[q] = c;

            p++;
            q--;
        }
    }

}
