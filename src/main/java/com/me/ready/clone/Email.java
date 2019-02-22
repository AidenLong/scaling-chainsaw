package com.me.ready.clone;

import java.io.Serializable;

public class Email implements Serializable {

    private String content;

    public Email(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "content='" + content + '\'' +
                '}';
    }
}
