package com.example.administrator.onnara;


public class Article
{
    String title;
    String writer;
    String content;
    String sendName;

    public Article(String title, String writer, String content, String sendName) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.sendName = sendName;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public String getSendName() {
        return sendName;
    }
}
