package com.osk.team.domain;

import java.sql.Date;
import java.util.List;

public class Hotplace {

    private int no;//게시판 번호
    private String title;//게시판 제목
    private String content;//게시판 내용
    private Date date;//등록 날짜
    private int count;//조회수
    private String address;//주소
    private String photo;//사진

    @Override
    public String toString() {
        return "Hotplace{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", count=" + count +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
