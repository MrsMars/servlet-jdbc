package com.aoher.services.impl;

import com.aoher.dao.BookMarkDao;
import com.aoher.dao.BookMarkDaoImpl;

import com.aoher.domain.BookMark;
import com.aoher.services.BookMarkService;

public class BookMarkServiceImpl implements BookMarkService {

    @Override
    public BookMark getBookMark(long accountID) {
        BookMarkDao bookmarkdao = new BookMarkDaoImpl();
        return bookmarkdao.getBookMark(accountID);
    }
}
