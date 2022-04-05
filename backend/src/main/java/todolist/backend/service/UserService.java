package todolist.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import todolist.backend.model.UserEntity;
import todolist.backend.persistence.UserRepository;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity, final PasswordEncoder encoder) {
        if (userEntity == null || userEntity.getEmail() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = userEntity.getEmail();
        if (userRepository.existsByEmail(email)) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        String encryptedPassword = encoder.encode(userEntity.getPassword());
        userEntity.setPassword(encryptedPassword);
        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
        final UserEntity originalUser = userRepository.findByEmail(email);
        String encryptedPassword = originalUser.getPassword();

        if(originalUser != null &&
            encoder.matches(password, originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }
}
