package org.mo.content.service.mobile.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFLoginService {
    @Test
    public void testLogin() throws ParseException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.16:8020/eai.mobile.account.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        listPram.add(new BasicNameValuePair("passport", "张曼"));
        listPram.add(new BasicNameValuePair("password", "123456"));
        // listPram.add(new BasicNameValuePair("mo-session-id",
        // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
        listPram.add(new BasicNameValuePair("app_key",
                "58BEFC782B9E4CE5A65B34B8C1E89141"));
        post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421023");

        listPram.add(new BasicNameValuePair("action", "login"));
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }
    }

    @Test
    public void testLogout() throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.100:8020/eai.mobile.account.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        // listPram.add(new BasicNameValuePair("mo-session-id",
        // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
        post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
        listPram.add(new BasicNameValuePair("action", "logout"));
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }
    }

    @Test
    public void testFeedback() {

    }

    @Test
    public void testAutoLogin() throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.100:8020/eai.mobile.account.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("action", "autoLogin"));
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        // listPram.add(new BasicNameValuePair("mo-session-id",
        // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
        post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }
    }

}
