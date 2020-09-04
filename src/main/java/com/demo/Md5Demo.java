package com.demo;

import com.demo.superdemo.Subclass;
import com.demo.superdemo.SuperClass;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.io.File;
import java.io.IOException;

public class Md5Demo {
    public static void main(String[] args) {
        /*String password = "cf2018";
        String salt = "1598262820745";//1597392266427
        System.out.println("salt = " + salt);

        String md5HashPassword = new Md5Hash(password, salt).toHex().toLowerCase();

        System.out.println("md5HashPassword = " + md5HashPassword);//8af9ca3bcec8e9f793db26d7233874a6


        Hash object = new SimpleHash("md5", "cf2020", "1597392266427", 1);
        String hashPass = ByteSource.Util.bytes(object).toHex();
        System.out.println("hashPass = " + hashPass);
        try {
            //info();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        System.out.println("-------------------");
        SuperClass[] superClasses = new SuperClass[3];*/
        /*try {
            String str = FileUtils.readFileToString(new File("C:\\Users\\86134\\Desktop\\ceshiAddFace.txt"), "UTF-8");
            System.out.println("str = " + str);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件异常!");
        }*/
/*        String str = "黄 崇 国 2";
        String str1 = str.replace(" ", "");

        System.out.println("str1 = " + str1);*/


        String gender = "410225199702092944";
        System.out.println("gender = " + gender.length());
        if(gender != null){
            String identity  = gender.substring(16, 17);
            int a = Integer.parseInt(identity);
            System.out.println("identity = " + (a%2));
        }

        String identity = "410225199702092542";
        if(identity != null){
            identity = identity.replace(identity.substring(6, 14), "*********");
        }

        System.out.println("identity = " + identity);
    }


    public static String coverIdentityCard(String identityCard) {
        if (identityCard == null) return "";
        if (identityCard.length() > 10) {
            identityCard = identityCard.replace(identityCard.substring(6, 14), "********");
        }
        return identityCard;
    }


    public static void info() throws Exception {
        System.out.println("start");
        String str = "s";
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Exception end");
            throw new Exception("此string字符串转换为int时出现异常:：" + str);
        }
        System.out.println("end");

    }
}
