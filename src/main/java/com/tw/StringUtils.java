package com.tw;

public class StringUtils {

    public static String doubleToString(double num){
        return subZeroAndDot(Double.toString(num));
    }

    /**
     * ����double����ĩβ��0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s == null) {
            return "";
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//ȥ�������0
            s = s.replaceAll("[.]$", "");//�����һλ��.��ȥ��
        }
        return s;
    }

}
