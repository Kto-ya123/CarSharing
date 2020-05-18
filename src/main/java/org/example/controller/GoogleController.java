package org.example.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.PlusScopes;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.config.ApiProviderConfig;
import org.example.config.ApiServiceConfiguration;
import org.example.entity.UserInfo;
import org.example.service.UserService;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("google/controller")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://ec2-18-188-63-75.us-east-2.compute.amazonaws.com"})
public class GoogleController {

    private final ApiServiceConfiguration configuration;
    private final UserService userService;

    @GetMapping(value = "/authorization_query")
    public ResponseEntity authorizationQuery(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws URISyntaxException {
        URI uri = new URI(configuration.getGoogle().getAuthorizeQuery());
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
//    @ResponseBody
    public RedirectView tokenResponse(HttpServletRequest req) throws IOException, URISyntaxException {

        ApiProviderConfig googleConfig = configuration.getGoogle();
        String code = req.getParameter("code");

        JSONObject requestObject = new JSONObject();
        requestObject.put("client_id", googleConfig.getClientId());
        requestObject.put("client_secret", googleConfig.getClientSecret());
        requestObject.put("redirect_uri", googleConfig.getRedirectUri());
        requestObject.put("code", code);
        requestObject.put("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestObject.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> loginResponse = restTemplate
                .exchange(googleConfig.getAccessTokenUri(), HttpMethod.POST, entity, String.class);
        JSONObject userJson = new JSONObject(loginResponse.getBody());
        GoogleTokenResponse googleTokenResponse = new GoogleTokenResponse();
        googleTokenResponse.setAccessToken(String.valueOf(userJson.get("access_token")));
        googleTokenResponse.setIdToken(String.valueOf(userJson.get("id_token")));
        googleTokenResponse.setScope(String.valueOf(userJson.get("scope")));
        String token = String.valueOf(userJson.get("id_token"));

        HttpTransport transport = new NetHttpTransport();

        List<String> applicationScopes = Arrays.asList(
                PlusScopes.USERINFO_EMAIL,
                PlusScopes.USERINFO_PROFILE,
                PlusScopes.PLUS_ME
        );

        GoogleAuthorizationCodeFlow flow
                = new GoogleAuthorizationCodeFlow.Builder(
                transport,
                JacksonFactory.getDefaultInstance(),
                googleConfig.getClientId(),
                googleConfig.getClientSecret(),
                applicationScopes).build();

        String userId = token;
        Credential credential = flow.createAndStoreCredential(googleTokenResponse, userId);
        HttpRequestFactory requestFactory = transport.createRequestFactory(credential);

        GenericUrl url = new GenericUrl("https://www.googleapis.com/oauth2/v1/userinfo");
        com.google.api.client.http.HttpRequest request = requestFactory.buildGetRequest(url);
        String userIdentity = request.execute().parseAsString();
        JSONObject clientInfo = new JSONObject(userIdentity);
        UserInfo userInfo = userService.saveUser(
                clientInfo.getString("id"),
                clientInfo.getString("name"),
                clientInfo.getString("given_name"),
                clientInfo.getString("family_name")
        );
        String jwt = Jwts.builder()
                .setExpiration(new Date(1300819380))
                .claim("name", userInfo.getName() + " " + userInfo.getSurname())
                .claim("user_id", userInfo.getExternalUserId())
                .signWith(SignatureAlgorithm.HS512,
                        "0ddf5597e02d981f8803c4cc11f015a4e52679d706edb29b595d9e466def5bcf95273a3053ab5d97ee893c23e4023b912daefaade316406a33b7685d4d223dfa").compact();

        return new RedirectView("http://localhost:4200/", true);
    }

}

