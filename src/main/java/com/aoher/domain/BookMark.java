package com.aoher.domain;

import java.util.Date;

public class BookMark {

    private long accountID;
    private long bookmarkID;
    private Date creationDate;
    private String mark;

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getBookmarkID() {
        return bookmarkID;
    }

    public void setBookmarkID(long bookmarkID) {
        this.bookmarkID = bookmarkID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
