package com.tw;

public class Constants {

    public static final String MAIN_MENU = "1. ���ѧ��\n" +
                                           "2. ���ɳɼ���\n" +
                                           "3. �˳�\n" +
                                           "���������ѡ��1��3����\n";

    private static final String STUDENT_INPUT_FORMAT = "����ʽ������, ѧ��, ѧ��: �ɼ�, ...��";
    private static final String QUERY_GRADE_LIST_FORMAT = "����ʽ�� ѧ��, ѧ��,...��";

    public static final String STDDENT_INPUT_MESSAGE = String.format("������ѧ����Ϣ%s�����س��ύ��\n", STUDENT_INPUT_FORMAT);
    public static final String STUDENT_INPUT_FORMAT_ERROR = String.format("�밴��ȷ�ĸ�ʽ����%s��\n", STUDENT_INPUT_FORMAT);

    public static final String STUDENT_INPUT_SUCCESS_MESSAGE = "ѧ��%s�ĳɼ������";

    public static final String QUERY_GRADE_LIST_MESSAGE = String.format("������Ҫ��ӡ��ѧ����ѧ��%s�����س��ύ��\n", QUERY_GRADE_LIST_FORMAT);
    public static final String QUERY_GRADE_LIST_FORMAT_ERROR = String.format("�밴��ȷ�ĸ�ʽ����Ҫ��ӡ��ѧ����ѧ��%s�����س��ύ��\n", QUERY_GRADE_LIST_FORMAT);

    public static final String GRADE_LIST_HEADER = "�ɼ���\n" +
            "����|��ѧ|����|Ӣ��|���|ƽ����|�ܷ�\n" +
            "========================\n";

}
