package kz.rassul_ghul.oblachko.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserModel userModel) {
        usersService.createUser(userModel.getUserName(), userModel.getPassword());
    }

    @Getter
    @Setter
    public static class UserModel {
        private String userName;
        private String password;

    }
}
