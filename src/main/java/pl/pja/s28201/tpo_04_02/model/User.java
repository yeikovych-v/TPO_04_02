package pl.pja.s28201.tpo_04_02.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name = "FORUM_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Article> articles;
    @OneToOne(fetch = FetchType.EAGER)
    private Blog managedBlog;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String email, Set<Article> articles, Blog managedBlog, Set<Role> roles) {
        this.email = email;
        this.articles = articles;
        this.managedBlog = managedBlog;
        this.roles = roles;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Blog getManagedBlog() {
        return managedBlog;
    }

    public void setManagedBlog(Blog managedBlog) {
        this.managedBlog = managedBlog;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id && Objects.equals(email, user.email) && Objects.equals(articles, user.articles) && Objects.equals(managedBlog, user.managedBlog) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, articles, managedBlog, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", articles=" + articles +
                ", managedBlog=" + managedBlog +
                ", roles=" + roles +
                '}';
    }
}
