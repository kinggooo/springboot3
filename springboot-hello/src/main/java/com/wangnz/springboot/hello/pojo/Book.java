package com.wangnz.springboot.hello.pojo;

import java.util.List;

public class Book {
    public String name;
    public List<Paper> papers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }
}
