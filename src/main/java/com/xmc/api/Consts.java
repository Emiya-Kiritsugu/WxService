package com.xmc.api;

/**
 * Created by xmc1993 on 16/4/7.
 */
public class Consts {

    public static final boolean ASYNC = false;
    public static final String NUMGER_EVENT_ID = "CS_NUMBER";
    public static final String WEIBO_EVENT_ID = "CS_WEIBO";

    //TODO 后期改成配置文件实现
    public static final String MENU = "{\n" +
            "\t\"menu\" : {\n" +
            "\t\t\"button\" : [\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"name\" : \"最新资讯\",\n" +
            "\t\t\t\t\"sub_button\" : [\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"智汇教育\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showNotice\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"教师风采\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showteacher\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"学生风采\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showstudent\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"name\" : \"暑期课程\",\n" +
            "\t\t\t\t\"sub_button\" : [\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"高中课程\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showSenior\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"初中课程\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showJunior\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"view\",\n" +
            "\t\t\t\t\t\t\"name\" : \"小学课程\",\n" +
            "\t\t\t\t\t\t\"url\" : \"http://120.27.219.173/view/showPrimary\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"name\" : \"联系我们\",\n" +
            "\t\t\t\t\"sub_button\" : [\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"click\",\n" +
            "\t\t\t\t\t\t\"name\" : \"客服电话\",\n" +
            "\t\t\t\t\t\t\"key\" : \"CS_NUMBER\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"type\" : \"click\",\n" +
            "\t\t\t\t\t\t\"name\" : \"官方微博\",\n" +
            "\t\t\t\t\t\t\"key\" : \"CS_WEIBO\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "}";

}
