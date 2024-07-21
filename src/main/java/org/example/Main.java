package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //내가 어떤 DB를 사용하는지를 정해주는 연결 주소
        String connectionString = "jdbc:sqlite:db.sqlite";
        //DB에 연결하고
        try(Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connection Success!!!");
            //데이터베이스에 SQL문(SQL Statement)를 전달할 준비를 한다.
            Statement statement = connection.createStatement();
            //실제 SQL문을 전달한다
            statement.execute("""
                    DROP TABLE IF EXISTS user;
                    """);
            statement.execute("""
                    CREATE TABLE user (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user TEXT,
                    password TEXT,
                    first_name TEXT,
                    last_name TEXT,
                    email TEXT
                    );
                    """);
            statement.execute("""
                    INSERT INTO user (id, user,password,first_name,last_name,email)
                    VALUES (1,'bbbb','long2810','Brad','Pete','brad@gmail.com');
                    """);
            statement.execute("""
                    INSERT INTO user (id, user,password,first_name,last_name,email)
                    VALUES (2,'bbbb','long2810','Brad','Pete','brad@gmail.com');
                    """);
            /*String insertSql = """
tatement.execute("""
                    INSERT INTO user (id, user,password,first_name,last_name,email)
                    VALUES (2,'bbbb','long2810','Brad','Pete','brad@gmail.com');
                    """);                    INSERT INTO user(user,password)
                    VALUES ('%s','%s');
                    """;
            Scanner scanner = new Scanner(System.in);
            System.out.println("input username: ");
            String username = scanner.nextLine();
            System.out.println("input password: ");
            String password = scanner.nextLine();
            statement.execute(String.format(insertSql,username,password));*/

            ResultSet resultSet = statement.executeQuery("""
                    SELECT * FROM user;
                    """);
            //resultSet.next()를 호출하면 다음  줄로 이동한다
            resultSet.next();
            //데이터 있으면 true, 없으면 false가 된다.
            resultSet.next();
            //get{type}() 메소드로 해당 줄의 데이터를 회수한다
            Long id = resultSet.getLong("id");
            System.out.println(id);
            String username = resultSet.getString("user");

            String updateSql = """
                    UPDATE user
                    SET first_name = 'Alexander'
                    WHERE email LIKE '%@gmail.com';
                    """;
            //executeUpdate()는 변경된 줄의 개수를 반환한다
            int rows = statement.executeUpdate(updateSql);
            System.out.println(rows);
        }catch(SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}