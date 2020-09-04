package com.corsface.base.util;

import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by wbb on 2020/8/13.
 */
public class Utils {

    protected static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static boolean isBlank(String s) {
        boolean rst = true;
        if ((s != null) && (s.length() > 0)) {
            rst = false;
        }
        return rst;
    }

    public static String clean(String in) {
        return StringUtils.clean(in);
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
}
