package com.itheima;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {

    //复制文件夹
    @Test
    public void writeStringToFile(){
        String mes = "我没有下班" ;

        String filePath2 = "D:/abc.txt" ;
        File file2 = new File( filePath2 ) ;

        try {
            //append参数：如果为true就追加到文件尾部，如果为false就从头开始写进行覆盖
            FileUtils.writeStringToFile( file2 , mes , "UTF-8" , false );
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制文件夹
    @Test
    public void copyFile() throws IOException {

        String filePath1 = "D:/abc.txt" ;
        String filePath2 = "D:/abc2.txt" ;

        File file1 = new File( filePath1 ) ;
        File file2 = new File( filePath2 ) ;

        //复制文件
        FileUtils.copyFile( file1 , file2);
    }

    //下载文件
    @Test
    public void copyURLToFile() throws IOException {

        String url = "http://imgsrc.baidu.com/baike/pic/item/7aec54e736d12f2ee289bffe4cc2d5628435689b.jpg" ;

        String filePath2 = "D:/bb.jpg" ;
        File file2 = new File( filePath2 ) ;

        try {

            FileUtils.copyURLToFile( new URL( url ) , file2 );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //复制文件夹
    @Test
    public void copyDirectory() throws IOException {

        String filePath1 = "D:/53/init" ;
        File file1 = new File( filePath1 ) ;

        String filePath2 = "D:/53/init4" ;
        File file2 = new File( filePath2 ) ;

        try {
            //复制文件夹
            FileUtils.copyDirectory( file1 , file2 );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //把字节数组写入文件
    @Test
    public void writeByteArrayToFile() throws IOException {

        String mes = "哈哈，下班了" ;

        String filePath2 = "D:/abc.txt" ;
        File file2 = new File( filePath2 ) ;

        try {
            byte[] mesArray = mes.getBytes() ;
            FileUtils.writeByteArrayToFile( file2 , mesArray ,false );
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //把集合里面的内容写入文件
    @Test
    public void writeLines() throws IOException {

        List<String> list = new ArrayList<>() ;

        String mes = "哈哈，下班了" ;
        String mes2 = "回家，回家" ;

        list.add( mes ) ;  //第一行数据
        list.add( mes2 ) ; //第二行数据

        String filePath2 = "D:/abc.txt" ;
        File file2 = new File( filePath2 ) ;

        try {
            FileUtils.writeLines( file2 , list );
            //每一行以。结尾
            //FileUtils.writeLines( file2 , list, "。");
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


//    //删除一个文件夹，包括文件夹和文件夹里面所有的文件
//    void deleteDirectory(final File directory)
//
//    //清空一个文件夹里面的所有的内容
//    void cleanDirectory(final File directory)
//
//    //删除一个文件，会抛出异常
////如果file是文件夹，就删除文件夹及文件夹里面所有的内容。如果file是文件，就删除。
////如果某个文件/文件夹由于某些原因无法被删除，会抛出异常
//    void forceDelete(final File file)
//
//    //删除一个文件，没有任何异常抛出
////如果file是文件夹，就删除文件夹及文件夹里面所有的内容。如果file是文件，就删除。
////如果某个文件/文件夹由于某些原因无法被删除，不会抛出任何异常
//    boolean deleteQuietly(final File file)


    //创建文件夹
    @Test
    public void forceMkdir() throws IOException {

        String filePath = "D:/123/abc/abcd" ;
        File file = new File( filePath ) ;

        try {
            //一次可以创建单级或者多级目录
            FileUtils.forceMkdir(file);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取文件
    @Test
    public void readFileToString() throws IOException {

        String filePath = "D:/abc.txt" ;
        File file = new File( filePath ) ;

        try {
            String s = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(s);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
