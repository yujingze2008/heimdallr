package com.gitee.fun2code.util;

import cn.hutool.setting.dialect.Props;

public class PropsUtil {

    Props props = null;

    public PropsUtil(String path) {
        props = new Props(path);
    }

    public String getString(String key) {
        return props.getStr(key);
    }

    public int getInt(String key) {
        return props.getInt(key);
    }

    public Object get(String key) {
        return props.get(key);
    }

}
