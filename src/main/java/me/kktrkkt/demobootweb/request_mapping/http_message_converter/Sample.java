package me.kktrkkt.demobootweb.request_mapping.http_message_converter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sample {

    private String title;

    private String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
