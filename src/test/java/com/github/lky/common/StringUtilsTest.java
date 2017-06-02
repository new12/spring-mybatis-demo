package com.github.lky.common;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longkeyu on 2017/6/2.
 */
public class StringUtilsTest {
    @Test
    public void testJoin(){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(StringUtils.join(list, ","));
    }
}
