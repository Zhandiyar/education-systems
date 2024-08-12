package kz.example.educationSystems.config;

import kz.example.educationSystems.model.Role;
import kz.example.educationSystems.model.User;
import kz.example.educationSystems.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner dataLoaderUser()  {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User( "teacher", passwordEncoder.encode("teacher"), Role.TEACHER));
                userRepository.save(new User( "student", passwordEncoder.encode("student"), Role.STUDENT));
            }
        };
    }
}
