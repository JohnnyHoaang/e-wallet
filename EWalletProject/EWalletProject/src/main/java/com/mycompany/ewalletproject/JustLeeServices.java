//Johnny Hoang
package com.mycompany.ewalletproject;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
public class JustLeeServices {
    public static Connection getConnection(String username, String password) throws SQLException {

        return DriverManager.getConnection("jdbc:oracle:thin:@198.168.52.211:1521/pdbora19c.dawsoncollege.qc.ca",
        username, password);
    }

    public static Book getBook(String vIsbn, Connection con) {
        Book newBook = null;
        Publisher newPub = null;
        try {
            var pubquery = "Select * from publisher JOIN BOOKS USING (pubid) where isbn = ?";
            var bookquery = "Select * FROM BOOKS WHERE ISBN = ?";
            PreparedStatement pubInfo = con.prepareStatement(pubquery);
            PreparedStatement booksInfo = con.prepareStatement(bookquery);
            pubInfo.setString(1, vIsbn);
            booksInfo.setString(1, vIsbn);
            var pResult = pubInfo.executeQuery();
            if(pResult.next()){
                newPub = new Publisher(pResult.getInt("pubid"), pResult.getString("name"), pResult.getString("contact"), pResult.getString("phone"));
            }
            var bResult = booksInfo.executeQuery();
            if (bResult.next()) {
                newBook = new Book(vIsbn, bResult.getString("title"), bResult.getDate("pubdate"),
                 newPub, bResult.getDouble("cost"), bResult.getDouble("retail"), 
                 bResult.getDouble("discount"), bResult.getString("category"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return newBook;
    }

    public static void addBook(Book bookInfo, Connection con) throws SQLException {
        var pubQuery = "INSERT INTO publisher VALUES(?,?,?,?)";
        PreparedStatement publishers = con.prepareStatement(pubQuery);
        publishers.setInt(1, bookInfo.getPublisher().getPubid());
        publishers.setString(2, bookInfo.getPublisher().getName());
        publishers.setString(3, bookInfo.getPublisher().getContact());
        publishers.setString(4, bookInfo.getPublisher().getPhone());
        var bookQuery = "INSERT INTO BOOKS VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement books = con.prepareStatement(bookQuery);
        books.setString(1, bookInfo.getisbn());
        books.setString(2, bookInfo.getTitle());
        books.setDate(3, bookInfo.getPubdate());
        books.setInt(4, bookInfo.getPublisher().getPubid());
        books.setDouble(5, bookInfo.getCost());
        books.setDouble(6, bookInfo.getRetail());
        books.setDouble(7, bookInfo.getDiscount());
        books.setString(8, bookInfo.getCategory());
        publishers.executeUpdate();
        books.executeUpdate();
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = reader.next();
        System.out.println("Enter password: ");
        String password = reader.next();
        Connection conn = null;
        try {
            conn = getConnection(username, password);
            Publisher publisher = new Publisher(7,"DAWSON COLLEGE INC.", "JOHNNY HOANG", "514-931-8731");
            Book book = new Book("3559286321", "THE WONDERS OF PL/SQL", Date.valueOf(LocalDate.now()), publisher, 234.65, 249.99,1, "COMPUTERS");
            addBook(book, conn);
            Book otherBook = getBook("3559286321", conn);
            System.out.println(otherBook);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }


}