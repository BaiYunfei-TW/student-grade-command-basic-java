package com.tw;

public class Constants {

    public static final String MAIN_MENU = "1. 添加学生\n" +
                                           "2. 生成成绩单\n" +
                                           "3. 退出\n" +
                                           "请输入你的选择（1～3）：\n";

    private static final String STUDENT_INPUT_FORMAT = "（格式：姓名, 学号, 学科: 成绩, ...）";
    private static final String QUERY_GRADE_LIST_FORMAT = "（格式： 学号, 学号,...）";

    public static final String STDDENT_INPUT_MESSAGE = String.format("请输入学生信息%s，按回车提交：\n", STUDENT_INPUT_FORMAT);
    public static final String STUDENT_INPUT_FORMAT_ERROR = String.format("请按正确的格式输入%s：\n", STUDENT_INPUT_FORMAT);

    public static final String STUDENT_INPUT_SUCCESS_MESSAGE = "学生%s的成绩被添加";

    public static final String QUERY_GRADE_LIST_MESSAGE = String.format("请输入要打印的学生的学号%s，按回车提交：\n", QUERY_GRADE_LIST_FORMAT);
    public static final String QUERY_GRADE_LIST_FORMAT_ERROR = String.format("请按正确的格式输入要打印的学生的学号%s，按回车提交：\n", QUERY_GRADE_LIST_FORMAT);

    public static final String GRADE_LIST_HEADER = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n" +
            "========================\n";

}
