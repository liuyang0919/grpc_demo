package com.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: liuyang
 * @Date: 18-10-24 19:26
 * @Description:
 */
public class Test {


    public static void main(String[] args) throws Exception {
        String a = "/add?a=anc123%E5%AF%B9%E5%AF%B9%E5%AF%B9";
        String b = URLDecoder.decode(a,"utf-8");
        System.out.println(b);
        System.out.println(URLEncoder.encode(b,"utf-8"));
    }
}
