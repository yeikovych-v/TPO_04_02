package pl.pja.s28201.tpo_04_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pja.s28201.tpo_04_02.repository.ArticleRepository;
import pl.pja.s28201.tpo_04_02.repository.BlogRepository;
import pl.pja.s28201.tpo_04_02.repository.RoleRepository;
import pl.pja.s28201.tpo_04_02.repository.UserRepository;

@Service
public class ConsoleService {

    private final ArticleRepository articleRepository;
    private final BlogRepository blogRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ConsoleService(ArticleRepository articleRepository, BlogRepository blogRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.blogRepository = blogRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void printDatabase() {
        articleRepository.findAll().forEach(System.out::println);
        blogRepository.findAll().forEach(System.out::println);
        roleRepository.findAll().forEach(System.out::println);
        userRepository.findAll().forEach(System.out::println);
    }

    public void printSeparator() {
        System.out.println("======================================================================================================================");
    }
}
