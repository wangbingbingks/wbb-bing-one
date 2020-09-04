package com.product.sc.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StringUtils {
    private static final String TAG = "StringUtils";

    public static String getExceptionAllinformation_01(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }

    public static String getWebPath(HttpServletRequest request) {
        String path = request.getContextPath();
        int port = request.getServerPort();

        String basePath = request.getScheme() + "://" + request.getServerName();
        if (port != 80) {
            basePath += ":" + request.getServerPort();
        }

        basePath += path + "/";

        return basePath;
    }


    public static String decimalFormat(Double d) {
        String result = "0";
        if (d != null) {
            double value = d - d.intValue();

            if (value == 0) {
                result = d.intValue() + "";
            } else {
                if ((value * 100) % 10 == 0) {
                    result = new DecimalFormat("#.0").format(d);
                } else {
                    result = new DecimalFormat("#.00").format(d);
                }
            }
        }

        if (result.startsWith(".")) {
            result = "0" + result;
        }

        return result;
    }


    public static String getRandomString(int length) {
        String rst = null;

        int size = length / 2;
        int remain = length % 2;
        if (remain != 0) {
            size++;
        }

        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        ByteSource byteSource = generator.nextBytes(size);

        rst = byteSource.toHex();

        return rst.substring(0, length);
    }

    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    public static int getStartIndex(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }

    public static int getDefaultIntParameter(HttpServletRequest request, String name, int defaultValue) {
        int rst = defaultValue;
        String value = getCleangParameter(request, name);
        try {
            rst = Integer.parseInt(value);
        } catch (Exception e) {
            //e.printStackTrace();
            rst = defaultValue;
        }
        return rst;
    }

    public static Integer getDefaultIntegerParameter(HttpServletRequest request, String name, Integer defaultValue) {
        Integer rst = defaultValue;
        String value = getCleangParameter(request, name);
        try {
            rst = Integer.parseInt(value);
        } catch (Exception e) {
            //e.printStackTrace();
            rst = defaultValue;
        }
        return rst;
    }

    public static long getDefaultLongParameter(HttpServletRequest request, String name, long defaultValue) {
        long rst = defaultValue;
        String value = getCleangParameter(request, name);
        try {
            rst = Long.parseLong(value);
        } catch (Exception e) {
            //e.printStackTrace();
            rst = defaultValue;
        }
        return rst;
    }

    public static Long getDefaultLongParameter(HttpServletRequest request, String name, Long defaultValue) {
        Long rst = defaultValue;
        String value = getCleangParameter(request, name);
        try {
            rst = Long.parseLong(value);
        } catch (Exception e) {
            //e.printStackTrace();
            rst = defaultValue;
        }
        return rst;
    }


    public static int getIntParameter(HttpServletRequest request, String name) {
        String number = getCleangParameter(request, name);
        return Integer.parseInt(number);
    }

    public static Double getDoubleParameter(HttpServletRequest request, String name) {
        String number = getCleangParameter(request, name);
        return Double.parseDouble(number);
    }

    public static int[] getIntArrayParameter(HttpServletRequest request, String name) {
        int[] rst = null;

        String value = getCleangParameter(request, name);
        if (value == null) {
            return rst;
        }
        String[] list = value.split(",");
        if (list != null) {
            rst = new int[list.length];
            for (int i = 0; i < list.length; i++) {
                if (isInteger(list[i])) {
                    rst[i] = Integer.parseInt(list[i]);
                }
            }
        }
        return rst;
    }

    public static long[] getLongArrayParameter(HttpServletRequest request, String name) {
        long[] rst = null;

        String value = getCleangParameter(request, name);
        String[] list = value.split(",");
        if (list != null) {
            rst = new long[list.length];
            for (int i = 0; i < list.length; i++) {
                if (isInteger(list[i])) {
                    rst[i] = Long.parseLong(list[i]);
                }
            }
        }
        return rst;
    }
    public static List<Long> getLongListParameter(HttpServletRequest request, String name) {
        List<Long> rst = null;

        String value = getCleangParameter(request, name);
        String[] list = value.split(",");
        if (list != null) {
            rst = new ArrayList<>();
            for (int i = 0; i < list.length; i++) {
                if (isInteger(list[i])) {
                    rst.add(Long.parseLong(list[i]));
                }
            }
        }
        return rst;
    }

    public static Long[] getLongArrayParameter2(HttpServletRequest request, String name) {
        Long[] rst = null;

        String value = getCleangParameter(request, name);
        String[] list = value.split(",");
        if (list != null) {
            rst = new Long[list.length];
            for (int i = 0; i < list.length; i++) {
                if (isInteger(list[i])) {
                    rst[i] = Long.parseLong(list[i]);
                }
            }
        }
        return rst;
    }

    /**
     * @param request
     * @param name
     * @return
     */
    public static List<String> getStringArrayParameter(HttpServletRequest request, String name) {

        List<String> rst = null;
        String value = getCleangParameter(request, name);
        if (value != null) {
            String[] list = value.split(",");
            if (list != null) {
                rst = new ArrayList<>();
                for (int i = 0; i < list.length; i++) {
                    rst.add(list[i]);
                }
            }
        }

        return rst;
    }

    public static Integer getNullIntParameter(HttpServletRequest request, String name) {
        Integer rst = null;
        String number = getCleangParameter(request, name);
        try {
            rst = Integer.parseInt(number);
        } catch (Exception e) {
//            e.printStackTrace();
            rst = null;
        }

        return rst;
    }

    public static Long getNullLongParameter(HttpServletRequest request, String name) {
        Long rst = null;
        String number = getCleangParameter(request, name);
        try {
            rst = Long.parseLong(number);
        } catch (Exception e) {
//            e.printStackTrace();
            rst = null;
        }

        return rst;
    }

    public static String replaceOtherStr(String str) {
        if (str == null) return null;
        return str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”()（）·]+", "");
    }

    public static String getCleangParameter(HttpServletRequest request, String name) {
        return clean(request.getParameter(name));
    }

    public static boolean isBlank(String s) {
        boolean rst = true;
        if ((s != null) && (s.length() > 0)) {
            rst = false;
        }
        return rst;
    }

    public static String clean(String in) {
        return org.apache.shiro.util.StringUtils.clean(in);
    }

    public static boolean isInteger(String s) {
        boolean rst = false;
        if (!isBlank(s)) {
            try {
                Long.parseLong(s);
                rst = true;
            } catch (Exception e) {
                rst = false;
            }
        }
        return rst;
    }

    public static boolean isIntegerList(String s) {
        boolean rst = false;
        if (!isBlank(s)) {
            String[] list = s.split(",");
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    if (!isInteger(list[i])) {
                        return false;
                    }
                }

                rst = true;
            }
        }
        return rst;
    }


    public static boolean isDouble(String s) {
        boolean rst = false;
        if (!isBlank(s)) {
            try {
                Double.parseDouble(s);
                rst = true;
            } catch (Exception e) {
                rst = false;
            }
        }
        return rst;
    }


    public static boolean isIntegerInRange(String s, int min, int max) {
        boolean rst = isInteger(s);
        if (!rst) {
            return false;
        }

        int value = Integer.parseInt(s);

        rst = (value >= min) && (value <= max);

        return rst;

    }

    public static boolean isIntegerInMin(String s, int min) {
        boolean rst = isInteger(s);
        if (!rst) {
            return false;
        }

        int value = Integer.parseInt(s);

        rst = value >= min;

        return rst;

    }

    public static boolean isMobile(String s) {
        if (!isInteger(s)) {
            return false;
        }
        return s.length() == 11;

    }

    public static String md5(String source) {
        Md5Hash md5 = new Md5Hash(source);
        return md5.toHex();
    }


    public static int getRandomNum() {
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        return num;
    }


    /**
     * 根据旧文件名（可为空）生成随机新文件名
     *
     * @param fileName
     * @return
     */
    public static String genRandomFileName(String fileName) {
        String rst = "";
        String prefix = genRandomFileNamePrefix();
        if (isBlank(fileName)) {
            return prefix;
        }

        int dotPos = fileName.lastIndexOf(".");
        if (dotPos == -1) {
            return prefix;
        } else {
            String suffix = fileName.substring(dotPos);
            rst = prefix + suffix;
        }

        return rst;
    }


    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        return str.replaceAll("-", "");
    }

    public static boolean checkEqual(Object arg1, Object arg2) {
        boolean result = false;
        if (arg1 == arg2) {
            result = true;
        }
        return result;
    }

    /**
     * 生成随即文件名前缀
     *
     * @return
     */
    public static String genRandomFileNamePrefix() {
        String rst = "";

        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        rst = System.currentTimeMillis() + "_" + generator.nextBytes(2).toHex();
        return rst;
    }

    public static String trimQueryPara(String query, String paraName) {
        StringBuffer rst = new StringBuffer();
        String[] array = query.split("&");

        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith(paraName + "=")) {

            } else {
                rst.append(array[i] + "&");
            }
        }
        if (rst.length() > 0) {
            rst.deleteCharAt(rst.length() - 1);
        }

        return rst.toString();
    }


    public static boolean isDateByFormat(String s, String format) {
        boolean rst = false;

        if (isBlank(s) || isBlank(format)) {
            return false;
        }

        if (s.length() != format.length()) {
            //长度不一致
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(s);
            System.out.println(date);
            rst = true;
        } catch (ParseException e) {
            e.printStackTrace();
            rst = false;
        }

        return rst;
    }

    public static String getCompleteUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 不去掉"-"符号
        return str;
    }

    public static String coverIdentityCard(String identityCard) {
        if (identityCard == null) return "";
        if (identityCard.length() > 10) {
            identityCard = identityCard.replace(identityCard.substring(6, 14), "********");
        }
        return identityCard;
    }
}
