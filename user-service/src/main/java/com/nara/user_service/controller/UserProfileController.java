import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nara.user_service.model.UserProfile;
import com.nara.user_service.service.UserProfileService;

//this controller is mainly accessed by the Auth Service in order to 
// add the profile for the user that has registered into the app

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

  private final UserProfileService userProfileService;

  public UserProfileController(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }

  @GetMapping
  @PreAuthorize(has_role"ADMIN") // add the security dependency later
  public List<UserProfile> getAllUserProfile(){
    return userProfileService.getAllProfile(); 
  }

  // never use put mapping btw !!
  @DeleteMapping("/delete/{id}")
  public String deleteById(@PathVariable Integer id) {
    userProfileService.deleteById(id);
    return "user profile deleted";
  }

  @PostMapping
  public String addUserProfile(@RequestBody UserProfile userProfile) {
    userProfileService.addUserProfile(userProfile);
    return "user profile added";
  }

}
