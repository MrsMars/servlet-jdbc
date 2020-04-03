package com.aoher.dao;

import com.aoher.domain.BookMark;
import com.aoher.factory.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BookMarkDaoImpl implements BookMarkDao {

    private static final Logger log = LoggerFactory.getLogger(BookMarkDaoImpl.class);

    ResultSet rs = null;

    @Override
    public BookMark getBookMark(long bookMarkID) {
        try (Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement()) {

            String sql = "SELECT accountID, bookmarkID, creationDate, bookmark FROM BOOKMARKS";
            rs = statement.executeQuery(sql);

            //Set into BookMark Object values
            BookMark bookMark = new BookMark();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                long accountID  = rs.getInt("accountID");
                long bookmarkID = rs.getInt("bookmarkID");
                Date creationDate = rs.getDate("creationDate");
                String completeBookMark = rs.getString("bookmark");

                bookMark.setAccountID(accountID);
                bookMark.setBookmarkID(bookmarkID);
                bookMark.setCreationDate(creationDate);
                bookMark.setMark(completeBookMark);
            }
            return bookMark;
        } catch (SQLException e) {
            log.error("SQL exception");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.error("SQL exception");
                }
            }
        }
        return null;
    }
}
