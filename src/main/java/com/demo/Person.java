package com.demo;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Person {
    private long id;
    private String name;

    public final static String MAIN_KEY_URL = "http://%s:%s/interface/get/getMasterKey";//主密钥地址

    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>();
        list.add("aaa");
        list.remove("aaa");

        System.out.println(list.toString());

        String str = getImgsFromList(list);
        System.out.println("str = " + str);

        String url = String.format(MAIN_KEY_URL, "192.168.1.107", "9091");
        System.out.println("url = " + url);*/

        /*File file = new File("E:\\ceshi\\ceshi1\\ceshi2");
        File file1 = file.getParentFile();
        if(!file1.exists()){
            file1.mkdirs();
        }*/

        /*String fileName = "http:dfkdsf?type=4&appid=this.CF_API_KEY+&id=facetrackId+&fn=upload_img.jpg";

        //fileName = fileName.substring(fileName.lastIndexOf("=")+1);
        int a = fileName.lastIndexOf("dsf?typ");
        System.out.println(a);

        System.out.println("fileName = " + fileName);*/
        /*String operatType = "1";
        if("1".equals(operatType)){

        }else{
            
        }

        if(!"1".equals(operatType) || !"2".equals(operatType)){

        }else{
            System.out.println("错误");
        }*/

        /*float f = 0.995070469156803634097534543543f;
        System.out.println("f = " + f);


        double d = 1.365266254651691651651465;
        System.out.println("d = " + d);*/
        /*DecimalFormat df3 = new DecimalFormat("###.00");
        String df = df3.format(f*100);
        *//*String ff = String.format("%.2f",f*100)+"%";
        System.out.println("ff = " + ff);*//*
        //System.out.println("df = " + df);

        String aa = String.format("%.3f", f*100)+"%";
        System.out.println("aa = " + aa);*/
        File file = new File("/mkfd/fd/fdf");
        if(file.exists()){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }

        String fn = null;
        System.out.println("fn = " + fn);

        String dfImgPath = "/data/images" + File.separator + "51651f2d15fs1d3f1sd32f21sd1fds" + "/person/" + "1545" + File.separator + "15459f5d6fdfg5d5g6fd" + File.separator + "111.jpg";

        System.out.println("dfImgPath = " + dfImgPath);

        /*StringBuffer error=new StringBuffer();
        for (int i = 0; i < 10; i++) {
            AtomicReference<String> errorContent= new AtomicReference<>("");//错误内容
            if(i == 0){
                errorContent.set("i为0时，有错误内容");
                return;
            }
            if(error.length() == 0){
                error.append(errorContent.get());
            }else{
                error.append(errorContent.get()).append(",");
            }
        }*/


    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        return str.replaceAll("-", "");
    }

    public static String getImgsFromList(List<String> list) {
        String rst = null;
        if (list == null || list.size() == 0) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                rst = "[";
            }

            rst += list.get(i);

            if (i == list.size() - 1) {
                rst += "]";
            } else {
                rst += ",";
            }

        }

        return rst;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
