package com.kd.core.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReadWriteFile {
	 public static BufferedReader bufread;
	    //指定文件路径和名称
//	    private static String path =System.getProperty("java.io.tmpdir").replace("%20", " ")+"\\DZCD"+new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
	    //测试用的路径
	 	private static String path ="D:\\kd\\J_"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"_pldk_01.txt";
	    private static  File filename = new File(path);
	    
	    private static String readStr ="";
	    private static final Logger logger=LoggerFactory.getLogger(ReadWriteFile.class);
	    
	    /**
	     * 创建文本文件.
	     * @throws IOException 
	     * 
	     */
	    public static void creatTxtFile() throws IOException{
	    	
	    	logger.info("创建txt文件在"+path+"位置");
	    	
	        if (!filename.exists()) {
	        	
	            filename.createNewFile();
	            
	            System.err.println(filename + "已创建！");
	            
	        }
	    }
	    
	    /**
	     * 读取文本文件.
	     * 
	     */
	    public static String readTxtFile(){
	    	
	        String read;
	        
	        FileReader fileread;
	        
	        try {
	            fileread = new FileReader(filename);
	            
	            bufread = new BufferedReader(fileread);
	            
	            try {
	            	
	                while ((read = bufread.readLine()) != null) {
	                	
	                    readStr = readStr + read+ "\r\n";
	                    
	                }
	                
	            } catch (IOException e) {
	            	
	                System.out.println("io出现异常，读取文本文件失败");
	                
	                logger.info("io出现异常，读取文本文件失败");
	                
	            }
	            
	        } catch (FileNotFoundException e) {
	        	
	        	System.out.println("没有发现可读取的文件");
	        	
	        	logger.info("没有发现可读取的文件");
	        	
	        }
	        
	        System.out.println("文件内容是:"+ "\r\n" + readStr);
	        
	        return readStr;
	    }
	    
	    /**
	     * 写文件.
	     * 
	     */
	    public static boolean writeTxtFile(String newStr) throws IOException{
	        //先读取原有文件内容，然后进行写入操作
	    	System.out.println(path);
	    	
//	        String filein = newStr + "\r\n" + readStr + "\r\n";
	        RandomAccessFile mm = null;
	        
	        boolean relg=false;
	        
	        try {
	            mm = new RandomAccessFile(filename, "rw");
	            
	            mm.seek(mm.length());
	            
	            mm.writeBytes(newStr+"\r\n");
	            
	            relg=true;
	            
	        } catch (IOException e1) {
	        	
	            // TODO 自动生成 catch 块
	            logger.info("出现异常，写入文件失败");
	            
	        } finally {
	        	
	            if (mm != null) {
	            	
	                try {
	                	
	                    mm.close();
	                    
	                } catch (IOException e2) {
	                	
	                    logger.info("出现异常，写入文件失败");
	                    
	                }
	            }
	        }
	        return relg;
	    }
	    
	    
	    
	    
	    
	    /**
	     * 将文件中指定内容的第一行替换为其它内容.
	     * 
	     * @param oldStr
	     *            查找内容
	     * @param replaceStr
	     *            替换内容
	     */
	    public static void replaceTxtByStr(String oldStr,String replaceStr) {
	        String temp = "";
	        try {
	            File file = new File(path);
	            FileInputStream fis = new FileInputStream(file);
	            InputStreamReader isr = new InputStreamReader(fis);
	            BufferedReader br = new BufferedReader(isr);
	            StringBuffer buf = new StringBuffer();

	            // 保存该行前面的内容
	            for (int j = 1; (temp = br.readLine()) != null
	                    && !temp.equals(oldStr); j++) {
	                buf = buf.append(temp);
	                buf = buf.append(System.getProperty("line.separator"));
	            }

	            // 将内容插入
	            buf = buf.append(replaceStr);

	            // 保存该行后面的内容
	            while ((temp = br.readLine()) != null) {
	                buf = buf.append(System.getProperty("line.separator"));
	                buf = buf.append(temp);
	            }

	            br.close();
	            FileOutputStream fos = new FileOutputStream(file);
	            PrintWriter pw = new PrintWriter(fos);
	            pw.write(buf.toString().toCharArray());
	            pw.flush();
	            pw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
