package com.demo.json;

import com.alibaba.fastjson.JSONObject;

public class TestJson {
    public static void main(String[] args) {

        String org = "{\n" +
                "\t\"magic\": 1,\n" +
                "\t\"taskState\": 0,\n" +
                "\t\"data\": {\n" +
                "\t\t\"offset\": [],\n" +
                "\t\t\"pin\": [{\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"2902\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"2069\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"1409\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"5819\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"1216\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"2485\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"2174\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"????\",\n" +
                "\t\t\t\"pin\": \"9621\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"?????\",\n" +
                "\t\t\t\"pin\": \"9874\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"errmsg\": \"??????\",\n" +
                "\t\t\t\"pin\": \"7813\"\n" +
                "\t\t}],\n" +
                "\t\t\"updateTime\": 0\n" +
                "\t},\n" +
                "\t\"accessKey\": \"temporary\",\n" +
                "\t\"SN\": \"2002A0980P003300100\",\n" +
                "\t\"orgid\": \"888888\",\n" +
                "\t\"taskId\": 13,\n" +
                "\t\"direction\": 1,\n" +
                "\t\"token\": \"\"\n" +
                "}";

        String str = "[{\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"2902\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"2069\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"1409\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"5819\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"1216\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"2485\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"2174\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"亮度不够\",\n" +
                "\t\"pin\": \"9621\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"清晰度不够\",\n" +
                "\t\"pin\": \"9874\"\n" +
                "}, {\n" +
                "\t\"errmsg\": \"检测不到人脸\",\n" +
                "\t\"pin\": \"7813\"\n" +
                "}]";

        JSONObject object = JSONObject.parseObject(org);
        JSONObject dataObj = object.getJSONObject("data");
        System.out.println(dataObj.toJSONString().length());

        System.out.println(str.length());

    }
}
