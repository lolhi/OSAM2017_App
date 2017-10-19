package com.example.administrator.onnara;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ProxyUp
{
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static String Url = "http://10.53.128.139:5016/";

    public static String getUrl() {
        return Url;
    }

    public static void upLoadCheck(InfoCheckId info, AsyncHttpResponseHandler reshandler)
    {
        RequestParams params = new RequestParams();

        params.add("id",info.getId());
        params.add("key",info.getKey());
        params.setForceMultipartEntityContentType(true);
        client.post(Url + "upload", params, reshandler);
    }

    public static void upLoadConfirm(InfoConfirm Info, AsyncHttpResponseHandler reshandler)
    {

        RequestParams params = new RequestParams();

        params.add("ID",Info.getOnnaraID());
        params.add("PW",Info.getOnnaraPW());
        params.add("key",Info.getKey());
        params.setForceMultipartEntityContentType(true);
        client.post(Url + "upload", params, reshandler);
}

    public static void upLoadRegister(InfoPerson Info, AsyncHttpResponseHandler reshandler)
    {
        RequestParams params = new RequestParams();


        params.add("Id",Info.getId());
        params.add("Password",Info.getPw());
        params.add("UnitName", Info.getUnitName());
        params.add("Name", Info.getName());
        params.add("key", "1");
        params.setForceMultipartEntityContentType(true);

        client.post(Url + "register",params,reshandler);
    }

    public static void upLoadArticle(Article Info, AsyncHttpResponseHandler reshandler)
    {
        RequestParams params = new RequestParams();

        params.add("title",Info.getTitle());
        params.add("writerName",Info.getWriter());
        params.add("content", Info.getContent());
        params.add("sendName", Info.getSendName());
        params.add("key", "2");
        params.setForceMultipartEntityContentType(true);

        client.post(Url + "register",params,reshandler);
    }


}
