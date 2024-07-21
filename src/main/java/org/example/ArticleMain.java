package org.example;

public class ArticleMain {
    public static void main(String[] args) {
        ArticleRepository repo = new ArticleRepository();
        repo.create(new Article(
                "test 1",
                "test content1"
                ));
        repo.create(new Article(
                "test 2",
                "test content2"
        ));
        repo.create(new Article(
                "test 3",
                "test content3"
        ));
        repo.create(new Article(
                "test 4",
                "test content4"
        ));

        for (Article article : repo.readAll()) {
            System.out.println(article);
        }
    }
}
