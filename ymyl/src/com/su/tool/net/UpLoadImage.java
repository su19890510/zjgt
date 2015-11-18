package com.su.tool.net;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class UpLoadImage {
    /**
     * 上传
     * 
     * @param pathList
     */
    public static void upload(List<String> pathList, String url) {
        String files = "FileUpload:";
        url = NetManager.HTTP_DOMAIN + url;
        for (int i = 0; i < pathList.size(); i++) {
            Log.i("HttpUrlEncodedFormEntityPost", "filePath:" + pathList.get(i));
            // 根据路径生成�?个Bitmap
            Bitmap tBitmap = convertToBitmap(pathList.get(i), 400, 400);
            // 把Bitmap写进流里�?
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            tBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            // 把流转化为数�?
            byte[] b = stream.toByteArray();
            // 将图片流以字符串形式存储下来
            String file = new String(Base64Coder.encodeLines(b));
            // 设置�?条分割线
            files += "---------------------------7da2137580612";
            // 累加每一个文件转化成的String数据
            files += file;
        }
        HttpClient client = new DefaultHttpClient();
        // 设置上传参数
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("file", files));
        HttpPost post = new HttpPost(url);
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            post.addHeader("Accept", "text/javascript, text/html, application/xml, text/xml");
            post.addHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
            post.addHeader("Accept-Encoding", "gzip,deflate,sdch");
            post.addHeader("Connection", "Keep-Alive");
            post.addHeader("Cache-Control", "no-cache");
            String BOUNDARY = "----------" + System.currentTimeMillis();
            post.setHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            // post.addHeader("Content-Type", "multipart/form-data");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            Log.v("HttpUrlEncodedFormEntityPost", "StatusCode: " + response.getStatusLine().getStatusCode());
            HttpEntity e = response.getEntity();
            Log.v("HttpUrlEncodedFormEntityPost", "response :" + EntityUtils.toString(e));
            if (200 == response.getStatusLine().getStatusCode()) {
                // Toast.makeTast(Activity,"上传完成",1000).show;
            } else {
                // Toast.makeTast(Activity,"上传失败",1000).show();
            }
            client.getConnectionManager().shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据路径生成�?个Bitmap
     * 
     * @param path
     * @param w 指定�?
     * @param h 指定�?
     * @return
     */
    public static Bitmap convertToBitmap(String path, int w, int h) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        // 设置为ture只获取图片大�?
        opts.inJustDecodeBounds = true;
        // 返回为空
        BitmapFactory.decodeFile(path, opts);
        int width = opts.outWidth;
        int height = opts.outHeight;
        int inSampleSize = 1;
        if (height > w || width > h) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) h);
            } else {
                inSampleSize = Math.round((float) width / (float) w);
            }
        }
        opts.inSampleSize = inSampleSize;
        opts.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, opts);
    }
}
