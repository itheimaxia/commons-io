package com.itheima;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IOUtilsTest {

    //copy：这个方法可以拷贝流，算是这个工具类中使用最多的方法了。支持多种数据间的拷贝。
    //copy内部使用的其实还是copyLarge方法。因为copy能拷贝Integer.MAX_VALUE的字节数据，即2^31-1。
    @Test
    public void writeStringToFile()  {
        String filePath = "D:/abc.txt" ;
        File file = new File( filePath ) ;
        try ( FileInputStream input = new FileInputStream(file)){
            String filepath2 = "D:/abc2.txt" ;
            File file2 = new File( filepath2 ) ;
            try ( FileOutputStream output = new FileOutputStream(file2)){
                IOUtils.copy(input,output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * copyLarge：这个方法适合拷贝较大的数据流，比如2G以上。
     * copyLarge(reader,writer) 默认会用1024*4的buffer来读取
     * copyLarge(reader,writer,buffer)
     */

    //按行读
    @Test
    public void readLinesTest(){
        try{
            InputStream is = new FileInputStream("D://abc.txt");
            List<String> lines = IOUtils.readLines(is,"UTF-8");
            for(String line : lines){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //读取字节
    @Test
    public void readTest() {
        try {
            byte[] bytes = new byte[24];
            InputStream is = IOUtils.toInputStream("hello world你好","UTF-8");
            IOUtils.read(is, bytes);
            System.out.println(new String(bytes));

            bytes = new byte[10];
            is = IOUtils.toInputStream("hello world","UTF-8");
            IOUtils.read(is, bytes, 2, 4);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }


    @Test
    public void toInputStream() {


        String meString = "哈哈哈哈，下班了，hello" ;

        try {

            InputStream inputStream = IOUtils.toInputStream( meString, "utf-8" ) ;
            String mes = IOUtils.toString( inputStream , "utf-8" ) ;
            System.out.println( mes );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void http() {

        String meString = "http://www.baidu.com" ;

        try {
            //模拟了http 请求
            String mes = IOUtils.toString( new URL( meString ) , "utf-8") ;
            System.out.println( mes );

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
