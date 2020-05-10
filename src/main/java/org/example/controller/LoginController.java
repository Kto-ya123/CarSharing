package org.example.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.entity.UserInfo;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping(value = "/login")
    public String mainPage(@RequestBody UserInfo user) {
        UserInfo findUser = userRepository.findByLogin(user.getLogin()).get();
        if(findUser.getName().equals(user.getName()) && findUser.getLogin().equals(user.getLogin())){
            String jwt = Jwts.builder()
                    .setExpiration(new Date(1300819380))
                    .claim("name", findUser.getName())
                    .claim("user_id", findUser.getExternalUserId())
                    .signWith(SignatureAlgorithm.HS512,
                            "0ddf5597e02d981f8803c4cc11f015a4e52679d706edb29b595d9e466def5bcf95273a3053ab5d97ee893c23e4023b912daefaade316406a33b7685d4d223dfa").compact();
            return jwt;
        }

        return null;
    }
}
