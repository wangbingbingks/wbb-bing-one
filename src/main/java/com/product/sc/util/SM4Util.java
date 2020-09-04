package com.product.sc.util;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.Key;
import java.security.Security;

public class SM4Util {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final Logger logger= LoggerFactory.getLogger(SM4Util.class);

    private static final String ENCODING="UTF-8";
    public static final String ALGORITHM_NAME = "SM4";
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";


    String masterKey = "1re59FU9hRzEm279";
    String workerKey = "1re59FU9hRzEm279";

    public static void main(String[] args)throws Exception {



        //String content=FileUtils.readFileToString(new File("/Users/nolan/Documents/requestParam.txt"),"UTF-8");

        //FileUtils.readFileToByteArray(new File(""));

        //System.out.println(decodeString("1re59FU9hRzEm279","+n65JhNi4HK3/0gm8tQlbhwZIvmQTdu0bvO4HrH69F1y1ellniAbS/kNRjd9uWJf3ooyoLHqsnbXi5wVbIyGiBZ6wwA5eRvpXK6eLXE0AR6KMKYTXd/xYFvT3lhvV8I5FTQF7r2cYRfaa8rI1hN0nnnCSTlAdVyBmIf8Uf/hj3CtM2pRLFgnKvfkReGMbvEKcCTO/Z2S7sqQ+mFQTAsN97resLZTNUXhzJ/nZgdiVElEK7USi9mI/KUmMj05S+glyEZ4uH785fzPq++EaXSOf2/1Ung8sbvpSVvSYVQAGyAhWr+u3jWY1u4UHcgsbWMwppbFGu7kVjKowW7eI6muFQLxA/YviMYZ2AK5ExcquSScDw5Ghn6W132nGy/2YgMDmLNTjm4k7f10zUFK3L8S1A=="));
        //System.out.println(encodeString("1re59FU9hRzEm279","[{\"idCardNumber\":\"410225199702096666\",\"operatType\":\"1\",\"faceData\":[{\"faceNumber\":\"4898af8f-525a-43b7-a748-6de95b56168d\",\"deviceNo\":\"2b79b888-d6c2-45eb-961d-6fbcd776a73f\"}]}]"));
        /*System.out.println(encodeString("1re59FU9hRzEm279","[{\"idCardNumber\":\"1DQQUFEM27NA0100007F00004E0E7B37\"," +
                "\"faceData\":[{\"faceNumber\":\"[139bec72-9d5e-401b-909a-2a5637b590cc,img_b36ca10f-8758-4b9c-b4e5-f70332e3d5dd.jpg]\",\"deviceNo\":\"\"},{\"faceNumber\":\"[8d5f0e0a-0f74-4576-bb8d-b6396d3c9489,img_9719c56f-dee9-4d29-b7a3-5e195b68fc80.jpg]\",\"deviceNo\":\"\"},{\"faceNumber\":\"[0411ce69-1096-47e1-a3f0-f83d6e3d9797,img_da82464d-2128-4b90-a34c-dd7c7ab5f31b.jpg]\",\"deviceNo\":\"\"}]}]"));*/


        //System.out.println(encodeString("1re59FU9hRzEm279", FileUtils.readFileToString(new File("C:\\Users\\86134\\Desktop\\ceshiAddFace.txt"), "UTF-8")));   //jiami
        //System.out.println(decodeString("1re59FU9hRzEm279",FileUtils.readFileToString(new File("C:\\Users\\86134\\Desktop\\加密的数据.txt"), "UTF-8")));       //jiemi

        String decode = encodeString("1re59FU9hRzEm279", "2134565");

        System.out.println(decode);


        System.out.println(decodeString("1re59FU9hRzEm279", decode));



    }
    /**
     * 将密文转为base64编码后再对+/=等进行处理
     *
     * @param key
     * @param plain
     * @return
     * @throws Exception
     */
    public static String encodeString(String key, String plain) throws Exception {
        long now=System.currentTimeMillis();
        logger.info("id:{}, key:{}, textString:{}",now,key, plain);
        byte[] bytes = new byte[0];
        String res=null;
        try {
            bytes = encrypt_Ecb_Padding(key.getBytes(), plain.getBytes(ENCODING));
            byte[] encode = Base64.encode(bytes);
            res=new String(encode);
            logger.info("id:{}, encodeString:{}",now, res);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("id:{}, failed encode",now);
            throw e;
        }

        return res;
    }

    /**
     * 将+/=还原后再进行解密操作
     * @param key
     * @param base64Cipher
     * @return
     * @throws Exception
     */
    public static String decodeString(String key, String base64Cipher) throws Exception {
        long now=System.currentTimeMillis();
        logger.info("id:{}, key:{}, cipherText:{}",now,key, base64Cipher);
        byte[] decode = Base64.decode(base64Cipher);
        byte[] bytes = new byte[0];
        String res=null;
        try {
            bytes = decrypt_Ecb_Padding(key.getBytes(), decode);
            res=new String(bytes,"utf-8");
            logger.info("id:{}, decodeString:{}",now, res);
        } catch (Exception e) {
            logger.info("id:{}, failed decode",now);
            e.printStackTrace();
            throw e;
        }
        return res;
    }

    /**
     * 生成ECB暗号
     *
     * @param algorithmName 算法名称
     * @param mode          模式
     * @param key
     * @return
     * @throws Exception
     */
    public static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     * 加密模式之ECB
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param key
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }
}
