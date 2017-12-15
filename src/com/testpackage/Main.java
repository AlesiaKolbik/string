package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();
        String separator = " ";
        String subString = cutSubString(inputString, separator);
        String capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNMЁЙЦУКЕНГШЩЗХЭЖДЛОРПАВЫФЯЧСМИТБЮ";
        ArrayList<String> arrayWords = split(subString, separator);
        ArrayList<String> arrayMatches = findMatchesInSubString(arrayWords, capitalLetters);
        printResult(arrayMatches);
    }

    private static String cutSubString(String string, String separator) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == separator.charAt(0)) {
                result = string.substring(i + 1);
                break;
            }
        }
        return result;
    }

    private static ArrayList<String> split(String string, String separator) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int startIndWord = findNextIndexWord(string, i, separator);
            int endIndWord = findLastIndexWord(string, startIndWord, separator);
            String word = string.substring(startIndWord, endIndWord);
            result.add(word);
            i = endIndWord;
        }
        return result;
    }

    private static int findNextIndexWord(String string, int index, String separator) {
        while (separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

    private static int findLastIndexWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
            if(index==string.length()-1)
                break;
        }
        return index;
    }

    private static ArrayList<String> findMatchesInSubString(ArrayList<String> arrayWords, String capitalLetters) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < arrayWords.size(); i++) {
            String word = arrayWords.get(i);
            for (int j = 0; j <= word.length() - 1; j++) {
                if (capitalLetters.contains(String.valueOf(word.charAt(j)))) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

    private static void printResult(ArrayList<String> arrayMatches) {
        if (arrayMatches.size() == 0) {
            System.out.println("Совпадений не найдено.");
        } else {
            System.out.println(arrayMatches);
        }
    }

}
