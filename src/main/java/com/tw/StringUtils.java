package com.tw;

public class StringUtils {

    public static String doubleToString(double num){
        return subZeroAndDot(Double.toString(num));
    }

    /**
     * 处理double类型末尾的0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s == null) {
            return "";
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

}
