package com.test.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author: liuyang
 * @Date: 18-10-26 10:58
 * @Description:
 */
public class Test {


    public static void main(String[] args) {
//       Test test = new Test();
//       test.test1();

//        System.out.println(Math.pow(1.9302,1/20));
        System.out.println(Pattern.matches("^[0-9]*$", "0100"));
//        Random random = new Random();
//        for(int i=0;i<100;i++){
//            System.out.println(random.nextInt(10));
//        }

    }

    private void test1(){
        String path = "/";
        File file = new File(path);

        FilenameFilter onluExt = new OnlyExt("a");
        String[] filenameArray = file.list(onluExt);
        if(filenameArray != null && filenameArray.length>0){
            Arrays.stream(filenameArray).forEach(o->{
                System.out.println(o);
            });
        }
        File[] files = file.listFiles(onluExt);
        Arrays.stream(files).forEach(o->{
            System.out.println(o.getAbsoluteFile());
        });
    }

    public class OnlyExt implements FilenameFilter {


        String ext;

        public OnlyExt(String ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }
}
