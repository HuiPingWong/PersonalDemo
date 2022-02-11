package com.example.PersonalDemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@SpringBootApplication
@MapperScan(value = {"com.example.PersonalDemo.dao"})
public class SpringbootApplication {

    public static void main(String[] args)  {
        SpringApplication.run(SpringbootApplication.class, args);


//       DriverService bean = ApplicationContextUtil.getBean(DriverService.class);
//       bean.driverBMW();




//        CarInfo carInfo = new CarInfo();
//        Class aClass = carInfo.getClass();
//        Class carInfoClass = CarInfo.class;
//        System.out.println(aClass+"\n"+carInfoClass+"\n"+(aClass==carInfoClass));



//        try{
//            String classname = "com.example.springboot.pojo.CarInfo";
//            Class<?> aClass1 = Class.forName(classname);
//            Method[] methods = aClass1.getDeclaredMethods();
//            for (Method s: methods) {
//                System.out.println(s);
//            }
//
//        }catch (ClassNotFoundException e){
//
//        }



//        File file = new File("/Users/Bbq/Desktop/file/energy.xls");
//        readExcel(file);


//        String sourceUrl="http://39.99.148.90:91/file/download?url=/sit-innovation/64191431a92e4e8fa2fe2f24e1d5a0f9/henantradefile/img/bfe40ae1b3f44eec8b117c2e07e3fafc.jpeg";
//        String destFilePath="/Users/Bbq/data/124.jpeg";
//        dowload(sourceUrl,destFilePath);






//        String url = "(ty o p   0)lk)&=";
//        url = url.replaceAll("[)]","）")
//                 .replaceAll("[(]","（")
//                 .replaceAll("&","A")
//                 .replaceAll("=","B")
//        .replaceAll(" +","");
//        System.out.println(url);


//        DemoPublisher bean = ApplicationContextUtil.getBean(DemoPublisher.class);
//        bean.publish("监听事件!");



//        List<Integer>list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.forEach(System.out::println);



//        int[] x=new int[3];
//        for (int m:x) {
//            System.out.println(m);
//        }
//        System.out.println("=====x======");
//        int[] y=x;
//        for (int m:y) {
//            System.out.println(m);
//        }
//        System.out.println("=====y======");
//        y[1]=100;
//        for (int m:x) {
//            System.out.println(m);
//        }
//        for (int m:y) {
//            System.out.println(m);
//        }
//        System.out.println("=====xy======");
//        x=null;
//        System.out.println("x:"+x);
//        for (int m:y) {
//            System.out.println(m);
//        }
//        System.out.println("=====null======");
    }





//    public static void readExcel(File file) {
//        List<Object> year=new ArrayList<>();
//
////        List<Object>marc=new ArrayList<>();
//        List<Object>basic=new ArrayList<>();
//        List<Object>low=new ArrayList<>();
//        List<Object>carbon=new ArrayList<>();
//
////        Integer num = 2019;
//        try {
//            // 创建输入流，读取Excel
//            InputStream is = new FileInputStream(file.getAbsolutePath());
//            // jxl提供的Workbook类
//            Workbook wb = Workbook.getWorkbook(is);
//            // Excel的页签数量
//            int sheet_size = wb.getNumberOfSheets();
//            System.out.println("Excel的页签数量:"+sheet_size);
//            for (int index = 0; index < sheet_size; index++) {
//                // 每个页签创建一个Sheet对象
//                Sheet sheet = wb.getSheet(index);
//                // sheet.getRows()返回该页的总行数
//                System.out.println("返回该页的总行数:"+sheet.getRows());
//                for (int i = 0; i < sheet.getRows(); i++) {
//                    // sheet.getColumns()返回该页的总列数
//                    System.out.println("返回该页的总列数:"+sheet.getColumns());
//                    for (int j = 0; j < sheet.getColumns(); j++) {
//                        String cellinfo = sheet.getCell(j, i).getContents();
//                        System.out.println(cellinfo);
//
//                        switch (j){
//                            case 0:
////                                year.add(num);
////                                num++;
//                                year.add(cellinfo);
//                                break;
//
//                            case 1:
//                                basic.add(cellinfo);
//                                break;
//
//                            case 2:
//                                low.add(cellinfo);
//                                break;
//
//                            case 3:
//                                carbon.add(cellinfo);
//                                break;
////
////                            case 4:
////                                carbon.add(cellinfo);
////                                break;
//                        }
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("year:"+year);
////        System.out.println("marc:"+marc);
//        System.out.println("basic:"+basic);
//        System.out.println("low:"+low);
//        System.out.println("carbon:"+carbon);
//    }
//
//
    public static void dowload(String sourceUrl,String destFilePath)throws Exception{
        DataInputStream in = null;
        DataOutputStream out = null;
        try{
//            sourceUrl = baseUrl + sourceUrl;
            log.info("=============================sourceUrl:"+sourceUrl);
            URL url = new URL(sourceUrl);
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setConnectTimeout(6000);
            urlCon.setReadTimeout(6000);
            int code = urlCon.getResponseCode();
            log.info("=============responseCode:"+code);
            if(code!=urlCon.HTTP_OK){
                throw new Exception("文件读取失败");
            }
            in = new DataInputStream(urlCon.getInputStream());
            out = new DataOutputStream(new FileOutputStream(destFilePath));

            byte[] buffer = new byte[2048];
            int count = 0;
            while((count=in.read(buffer))>0){
                out.write(buffer,0,count);
            }
        }catch(Exception e){
            log.info(";文件路径错误！");
            throw e;
        }finally{
            out.close();
            in.close();
        }
    }

}
