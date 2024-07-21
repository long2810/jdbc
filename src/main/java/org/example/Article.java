package org.example;
public class Article {
    private Long id;
    private String title;
    private String content;


    public Article() {}
    //새 게시글 작성을 위한 생성자
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //조회할 때 사용할 생성자
    public Article(Long id, String title,String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
