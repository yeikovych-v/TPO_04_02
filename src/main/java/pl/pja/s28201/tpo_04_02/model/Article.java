package pl.pja.s28201.tpo_04_02.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Blog blog;

    public Article(String title, Blog blog) {
        this.title = title;
        this.blog = blog;
    }

    public Article() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id == article.id && Objects.equals(title, article.title) && Objects.equals(blog, article.blog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, blog);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", blog=" + blog +
                '}';
    }
}
