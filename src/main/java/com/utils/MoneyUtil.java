package com.utils;

import com.exception.MoneyException;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 金额工具类
 */
public class MoneyUtil {

    /**
     * 判断money是否可以被当做金钱被计算
     * @param money
     * @return
     */
    public static boolean isMoney(String money) {

        return Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$").matcher(money).matches(); //判断小数点后2位的数字的正则表达式
    }

    /**
     * 判断money1是否大于money2
     * @param money1
     * @param money2
     * @return
     */
    public static boolean compareMoney(String money1, String money2) throws MoneyException {

        if (!isMoney(money1)) {
            throw new MoneyException
                    ("MoneyUtil类compareMoney方法 - money1参数不可被转成金钱来计算! - {}", money1);
        }

        if (!isMoney(money2)) {
            throw new MoneyException
                    ("MoneyUtil类compareMoney方法 - money2参数不可被转成金钱来计算! - {}", money2);
        }

        BigDecimal bigMoney1 = new BigDecimal(money1);
        BigDecimal bigMoney2 = new BigDecimal(money2);

        double subtract = bigMoney1.subtract(bigMoney2).doubleValue();
        return (subtract > 0) ? (true) : (false);
    }


    public static void main(String args[]) throws Exception {

        System.out.println(MoneyUtil.isMoney("5000.00"));
        System.out.println(MoneyUtil.compareMoney("-1", "0"));
    }
}
