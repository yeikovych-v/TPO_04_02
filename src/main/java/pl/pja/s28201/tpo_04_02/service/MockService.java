package pl.pja.s28201.tpo_04_02.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pja.s28201.tpo_04_02.model.Article;
import pl.pja.s28201.tpo_04_02.model.Blog;
import pl.pja.s28201.tpo_04_02.model.Role;
import pl.pja.s28201.tpo_04_02.model.User;
import pl.pja.s28201.tpo_04_02.repository.ArticleRepository;
import pl.pja.s28201.tpo_04_02.repository.BlogRepository;
import pl.pja.s28201.tpo_04_02.repository.RoleRepository;
import pl.pja.s28201.tpo_04_02.repository.UserRepository;

import java.util.*;

@Service
public class MockService {

    private final ArticleRepository articleRepository;
    private final BlogRepository blogRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public MockService(ArticleRepository articleRepository, BlogRepository blogRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.blogRepository = blogRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void mockDatabase() {
        List<Role> roles = mockRoles();
        List<Blog> blogs = mockBlogs();
        mockArticles(blogs);
        mockUsers(roles, blogs);
    }

    public void mockUsers(List<Role> roles, List<Blog> blogs) {
        for (int i = 1; i <= 20; i++) {
            String email = "Email_" + i;
            Blog blog = blogs.get(i - 1);
            List<Article> articles = articleRepository.findByBlog(blog);
            User user = new User(email, new HashSet<>(articles), blog, new HashSet<>(roles));
            userRepository.save(user);
        }
    }

    public List<Role> mockRoles() {
        List<Role> roles = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String roleName = "Role_" + i;
            Role role = new Role(roleName);
            roleRepository.save(role);
            roles.add(role);
        }
        return roles;
    }

    public void mockArticles(List<Blog> blogs) {
        for (int i = 1; i <= 20; i++) {
            Blog blog = blogs.get(i - 1);
            for (int j = 0; j < 3; j++) {
                String title = "Title_" + i + "_" + j;
                Article article = new Article(title, blog);
                articleRepository.save(article);
            }
        }
    }

    public List<Blog> mockBlogs() {
        List<Blog> blogs = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String name = "Name_" + i;
            Blog blog = new Blog(name);
            blogRepository.save(blog);
            blogs.add(blog);
        }
        return blogs;
    }
}
