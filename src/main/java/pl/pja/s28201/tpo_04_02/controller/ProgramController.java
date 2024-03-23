package pl.pja.s28201.tpo_04_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.pja.s28201.tpo_04_02.model.Article;
import pl.pja.s28201.tpo_04_02.model.Blog;
import pl.pja.s28201.tpo_04_02.model.Role;
import pl.pja.s28201.tpo_04_02.model.User;
import pl.pja.s28201.tpo_04_02.repository.ArticleRepository;
import pl.pja.s28201.tpo_04_02.repository.BlogRepository;
import pl.pja.s28201.tpo_04_02.repository.RoleRepository;
import pl.pja.s28201.tpo_04_02.repository.UserRepository;
import pl.pja.s28201.tpo_04_02.service.ConsoleService;
import pl.pja.s28201.tpo_04_02.service.MockService;

import java.util.*;

@Controller
public class ProgramController {

    private final MockService mockService;
    private final ConsoleService consoleService;

    private final ArticleRepository articleRepository;
    private final BlogRepository blogRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProgramController(MockService mockService,
                             ConsoleService consoleService,
                             ArticleRepository articleRepository,
                             BlogRepository blogRepository,
                             RoleRepository roleRepository,
                             UserRepository userRepository) {
        this.mockService = mockService;
        this.consoleService = consoleService;
        this.articleRepository = articleRepository;
        this.blogRepository = blogRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void startProgram() {
        mockService.mockDatabase();

        consoleService.printSeparator();
        consoleService.printDatabase();
        deleteSomeRecords();

        consoleService.printSeparator();
        consoleService.printDatabase();
        addSomeRecords();

        consoleService.printSeparator();
        consoleService.printDatabase();
        consoleService.printSeparator();
    }

    private void addSomeRecords() {
        for (int i = 0; i < 5; i++) {
            Role role = new Role("rrrole_" + i);
            roleRepository.save(role);
            Blog blog = new Blog("bbbblog_" + i);
            blogRepository.save(blog);
            Article article1 = new Article("aaaarticle_" + i, blog);
            Article article2 = new Article("aaaarticle__" + i, blog);
            Article article3 = new Article("aaaarticle___" + i, blog);
            Set<Article> articles = Set.of(article1, article2, article3);
            articleRepository.saveAll(articles);
            User user = new User("eeeemail_" + i, articles, blog, Set.of(role));
            userRepository.save(user);
        }
    }

    private void deleteSomeRecords() {
        int articleId = 1;
        for (int i = 1; i <= 5; i++) {
            userRepository.deleteById((long) i);
            for (int j = 0; j < 3; j++) {
                articleRepository.deleteById((long) articleId);
                articleId++;
            }
            blogRepository.deleteById((long) i);
        }
    }
}
