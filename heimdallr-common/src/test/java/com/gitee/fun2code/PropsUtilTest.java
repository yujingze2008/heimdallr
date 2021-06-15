package com.gitee.fun2code;

import com.gitee.fun2code.util.PropsUtil;
import org.junit.Assert;
import org.junit.Test;

public class PropsUtilTest {

    @Test
    public void test(){
        PropsUtil propsUtil = new PropsUtil("test.properties");
        Assert.assertEquals("test",propsUtil.getString("name"));
    }

}
