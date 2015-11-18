package com.su.tool.net;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;


import android.util.Log;

/**
 * 
 * 实锟斤拷锟侥硷拷锟较达拷锟侥癸拷锟斤拷锟斤拷
 * @Title: 
 * @Description: 实锟斤拷TODO
 * @Copyright:Copyright (c) 2011
 * @Company:锟阶程科硷拷锟缴凤拷锟斤拷锟睫癸拷司
 * @Date:2012-7-2
 * @author  longgangbai
 * @version 1.0
 */
public class UploadUtils {
	private static final String TAG = "uploadFile";
	private static final int TIME_OUT = 10*10000000;   //锟斤拷时时锟斤拷
	private static final String CHARSET = "utf-8"; //锟斤拷锟矫憋拷锟斤拷
	public static final String SUCCESS="1";
	public static final String FAILURE="0";
	public static String headImgPath = "";
	/**
	 * android锟较达拷锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param file  锟斤拷要锟较达拷锟斤拷锟侥硷�?
	 * @param RequestURL  锟斤拷锟斤拷锟絩ul
	 * @return  锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷锟斤�?
	 */
	public static String uploadFile(File file,String RequestURL)
	{
		String  BOUNDARY =  UUID.randomUUID().toString();  //锟竭斤拷锟绞�?   锟斤拷锟斤拷锟斤拷锟�?
		String PREFIX = "--" , LINE_END = "\r\n"; 
		String CONTENT_TYPE = "multipart/form-data";   //锟斤拷锟斤拷锟斤拷锟斤拷
		
		try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setDoInput(true);  //锟斤拷锟斤拷锟斤拷锟斤拷锟斤�?
			conn.setDoOutput(true); //锟斤拷锟斤拷锟斤拷锟斤拷锟�
			conn.setUseCaches(false);  //锟斤拷锟斤拷锟斤拷使锟矫伙拷锟斤�?
			conn.setRequestMethod("POST");  //锟斤拷锟斤拷�?
			conn.setRequestProperty("Charset", CHARSET);  //锟斤拷锟矫憋拷锟斤拷
			conn.setRequestProperty("connection", "keep-alive");   
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY); 
			if(file!=null)
			{
				/**
				 * 锟斤拷锟侥硷拷锟斤拷为锟秸ｏ拷锟斤拷锟侥硷拷锟斤拷装锟斤拷锟斤拷锟较达拷
				 */
				OutputStream outputSteam=conn.getOutputStream();
				
				DataOutputStream dos = new DataOutputStream(outputSteam);
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				/**
				 * 锟斤拷锟斤拷锟截碉拷注锟解：
				 * name锟斤拷锟斤拷锟街滴拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭猭ey   只锟斤拷锟斤拷锟絢ey 锟脚匡拷锟皆得碉拷锟斤拷应锟斤拷锟侥硷拷
				 * filename锟斤拷锟侥硷拷锟斤拷锟斤拷锟街ｏ拷锟斤拷锟斤拷锟斤拷�?锟斤拷锟斤拷   锟斤拷锟斤拷:abc.png  
				 */
				
				sb.append("Content-Disposition: form-data; name=\"file\"; filename=\""+file.getName()+"\""+LINE_END); 
				sb.append("Content-Type: application/octet-stream; charset="+CHARSET+LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while((len=is.read(bytes))!=-1)
				{
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX+BOUNDARY+PREFIX+LINE_END).getBytes();
				dos.write(end_data);
				dos.flush();
				/**
				 * 锟斤拷取锟斤拷应锟斤�?  200=锟缴癸拷
				 * 锟斤拷锟斤拷应锟缴癸拷锟斤拷锟斤拷取锟斤拷应锟斤拷锟斤拷  
				 */
				int res = conn.getResponseCode();  
				Log.v("response",conn.getResponseMessage());
				Log.e(TAG, "response code:"+res);
				InputStream inStream = conn.getInputStream();  
		          
		        BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "GBK"));  
		        StringBuffer buffer = new StringBuffer();  
		        String line = "";  
		        while ((line = in.readLine()) != null){  
		          buffer.append(line);  
		        }  
		       String str = buffer.toString();  
		       Log.v("suzhaohui",str);
		       UploadUtils.headImgPath = str;
				if(res==200)
				{
			     return SUCCESS;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
}