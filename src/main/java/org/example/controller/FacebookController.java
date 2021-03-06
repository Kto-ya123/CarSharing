package org.example.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.config.ApiProviderConfig;
import org.example.config.ApiServiceConfiguration;
import org.example.entity.UserInfo;
import org.example.service.UserService;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/facebook/controller")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://ec2-18-188-63-75.us-east-2.compute.amazonaws.com"})
public class FacebookController {

    private final ApiServiceConfiguration configuration;
    private final UserService userService;

    @GetMapping(value = "/authorization_query")
    public ResponseEntity authorizationQuery() throws URISyntaxException {
        URI uri = new URI(configuration.getFacebook().getAuthorizeQuery());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        httpHeaders.add("Access-Control-Allow-Credentials", "true");
        httpHeaders.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpHeaders.add("Access-Control-Max-Age", "3600");
        httpHeaders.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization," +
                "Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
        httpHeaders.add("Origin", "http://localhost:4200");
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/response")
    public RedirectView facebookTokenResponse(HttpServletRequest req) {
        ApiProviderConfig facebookConfig = configuration.getFacebook();
        String code = req.getParameter("code");
        JSONObject request = new JSONObject();
        request.put("client_id", facebookConfig.getClientId());
        request.put("client_secret", facebookConfig.getClientSecret());
        request.put("redirect_uri", facebookConfig.getRedirectUri());
        request.put("code", code);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> loginResponse = restTemplate
                .exchange(facebookConfig.getAccessTokenUri(), HttpMethod.POST, entity, String.class);
        JSONObject userJson = new JSONObject(Objects.requireNonNull(loginResponse.getBody()));
        String token = String.valueOf(userJson.get("access_token"));
        ResponseEntity<String> response = restTemplate
                .exchange(facebookConfig.getUserinfoUri() + "?fields=last_name,first_name&access_token=" + token, HttpMethod.GET,
                        entity, String.class);
        JSONObject clientInfo = new JSONObject(Objects.requireNonNull(response.getBody()));
        String name = clientInfo.getString("first_name");
        String surname = clientInfo.getString("last_name");
        UserInfo userInfo = userService.saveUser(
                String.valueOf(clientInfo.getLong("id")),
                name + " " + surname,
                name,
                surname
        );
        String jwt = Jwts.builder()
                .setExpiration(new Date(1300819380))
                .claim("name", userInfo.getName() + " " + userInfo.getSurname())
                .claim("user_id", userInfo.getExternalUserId())
                .signWith(SignatureAlgorithm.HS512,
                        "0ddf5597e02d981f8803c4cc11f015a4e52679d706edb29b595d9e466def5bcf95273a3053ab5d97ee893c23e4023b912daefaade316406a33b7685d4d223dfa").compact();
        return new RedirectView(String.format("http://localhost:4200", jwt), true);
    }
}

