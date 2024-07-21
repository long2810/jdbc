package org.example;

import java.sql.*;
import java.util.*;

//ArticleDao - Data Access Object
public class ArticleRepository {
    //데이터베이스와의 연결
    public final Connection connection;

    //ArticleRepository가 생성될 때 DB랑 연결된다
    public ArticleRepository() {
        String connectString = "jdbc:sqlite:db.sqlite";
        try {
            connection = DriverManager.getConnection(connectString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 1.Article 생성 -> Use Insert
    public void create(Article article) {
        String insertSql = """
                INSERT INTO article(title, content) 
                VALUES (?,?);
                """;
        // PreparedStatement 준비
        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            int row = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    // 2.Article 목록 조회
    public List<Article> readAll() {
        String selectSql = "SELECT * FROM article;";
        //Statement 준비
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);

            //결과를 담을 리스트
            List<Article> articles = new ArrayList<>();
            //아직 읽을 데이터가 남은 동안
            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                ));
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    // 3.Article 개별 조회
    // 4.Article 삭제
}
