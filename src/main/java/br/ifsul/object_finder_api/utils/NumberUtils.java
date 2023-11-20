package br.ifsul.object_finder_api.utils;

public abstract class NumberUtils {
    public static String convertToTwoNumbers(Integer number) {
        return number >= 10 ? number.toString() : "0" + number;
    }
}
