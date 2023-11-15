package just.khao.com.controller;

import just.khao.com.entity.ProfileEntity;
import just.khao.com.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/test")
    public String TestProfile(){
        return "Profile OK";
    }

    @GetMapping("/retrieve")
    public ProfileEntity findProfile(
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "") String username
    ) throws Exception {
        if(!email.isEmpty()){
            return profileService.findByEmail(email);
        }
        if(!username.isEmpty()){
            return profileService.findByUsername(username);
        }
        throw new Exception("Not Allowed!");
    }
}
