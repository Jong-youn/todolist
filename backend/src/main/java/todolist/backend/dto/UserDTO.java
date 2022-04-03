package todolist.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import todolist.backend.model.UserEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {

    private String email;
    private String username;
    private String password;
    private String token;
    private String id;

//    public UserDTO(final UserEntity entity) {
//        this.email = entity.getEmail();
//        this.username = entity.getUsername();
//        this.password = entity.getPassword();
//    }
}
