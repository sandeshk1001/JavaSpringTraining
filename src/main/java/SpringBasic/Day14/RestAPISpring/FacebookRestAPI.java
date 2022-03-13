package SpringBasic.Day14.RestAPISpring;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class FacebookRestAPI {
    @PostMapping("facebook/createuser")
    List<String> createUser(@RequestBody String body){
        return Arrays.asList(body);
    }

    //http://localhost:8080/facebook/userdetail?userId=101
    @GetMapping("facebook/usersdetail")
    List<String> userDetails(@RequestParam String userId){
        return Arrays.asList(userId,"user-1");
    }

    //http://localhost:8080/facebook/userfriendlist?userId=101      GET
    @GetMapping("facebook/userfriendlist")
    List<String> friendList(@RequestParam String userId){
        return Arrays.asList("user1","user2","user3","user4");
    }



}
