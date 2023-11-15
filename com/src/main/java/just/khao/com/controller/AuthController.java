package just.khao.com.controller;

import just.khao.com.entity.GoogleToken;
import just.khao.com.model.*;
import just.khao.com.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String TestAuth(){
        return "Auth OK";
    }

    @PostMapping("/refresh-token")
    public TokenModel RefreshToken(@RequestBody TokenModel tokenModel) {
        return authService.reIssueToken(tokenModel);
    }

    @PostMapping("/google")
    public TokenModel GoogleSignIn(@RequestBody GoogleSigninModel googleSigninModel) throws Exception {
        GoogleToken googleIdToken = authService.extractGoogleToken(googleSigninModel.getToken());
        if(googleIdToken != null){
            return authService.createTokenFromGoogle(googleIdToken);
        } else {
            throw new AuthException("Invalid Google Account!");
        }
    }
}
