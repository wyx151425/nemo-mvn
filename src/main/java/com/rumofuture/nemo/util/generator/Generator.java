package com.rumofuture.nemo.util.generator;

import java.util.UUID;

/**
 * 特殊字符串生成器
 *
 * @author 王振琦
 */
public class Generator {
    public static String getObjectId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
