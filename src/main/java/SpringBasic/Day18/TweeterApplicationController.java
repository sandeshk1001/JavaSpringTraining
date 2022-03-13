package SpringBasic.Day18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TweeterApplicationController {
    private Map<String, User> userProfileMap = new HashMap<>();
    private Map<String, List<Tweet>> tweetsMap = new HashMap<>();
    private Map<String, List<String>> followmap = new HashMap<>();

    @Autowired
    Dao<User> userDao;
    @Autowired
    Dao<Tweet> tweetDao;

    //using of that we can open register page
    @GetMapping("/user/register")
    public ModelAndView openRegister(){
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    //using of that we can display all users on mustache
    @GetMapping("user/displayUserDetail")
    public ModelAndView getUserList(){
        ModelAndView modelAndView=new ModelAndView("userslist");
        if (userProfileMap.isEmpty())
            allAccDetails();
        List<User> userList=new ArrayList<>();
        for (Map.Entry entry:userProfileMap.entrySet()){
            userList.add((User) entry.getValue());
        }
        modelAndView.getModel().put("users",userList);
        return modelAndView;
    }

    // get the data from register mustache page
    @PostMapping( value = "/user/createuser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView getRegiseteredData(@RequestBody MultiValueMap<String, String> formData){
        if (formData.isEmpty()){
            return errorMessageModelAndView(new ResponseEntity<>("No such data", HttpStatus.BAD_REQUEST).toString());
        }
        String name=formData.get("name").get(0);
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        return errorMessageModelAndView(createUser(new User(name,email,password)).toString());
    }

    /**
     * @USE using that we can create user web and postman both
     * @param user
     * @return responseEntity
     * @METHOD POST
     */
    @PostMapping("/user/createUser")
    private ResponseEntity<String> createUser(@RequestBody User user){
        ResponseEntity<String> responseEntity=null;
        String name=user.getName();
        String email=user.getEmail();
        String password=user.getPassword();
        if (containsInvalidChar(name))
            responseEntity=new ResponseEntity<>("name contains invalid character",HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or alerady present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else {
            userDao.create(user);
            userProfileMap.put(email,user);
            responseEntity=new ResponseEntity<>("Registered successfully",HttpStatus.OK);
        }
        return responseEntity;
    }

    // fetch all the user basically use for set map
    @GetMapping("/user/fetchUsers")
    @ResponseBody
    private Map<String, User> allAccDetails() {
        userProfileMap.clear();
        List<User> list =userDao.readAll();
        for (User user:list)
            userProfileMap.put(user.getEmail(),user);
        System.out.println("userlist :"+userProfileMap);
        return userProfileMap;
    }

    @PostMapping("/user/updateUser")
    private ResponseEntity<String> updateUser(@RequestBody User user){
        allAccDetails();
        ResponseEntity<String> responseEntity=null;
        String name=user.getName();
        String email=user.getEmail();
        String password=user.getPassword();
        if (containsInvalidChar(name))
            responseEntity=new ResponseEntity<>("name contains invalid character",HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) ){
            responseEntity=new ResponseEntity<>("Email contains invalid character or alerady present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else if(!isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email doesn't exist",HttpStatus.BAD_REQUEST);
        }else {
            userDao.update(user);
            userProfileMap.put(email,user);
            responseEntity=new ResponseEntity<>("Update successfully",HttpStatus.OK);
        }
        return responseEntity;
    }

    /*------------------validation-----------------------*/
    private ModelAndView errorMessageModelAndView(String message) {
        if (message.equals(null))
            message="message null";
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.getModel().put("message", message);
        return modelAndView;
    }

    private boolean containsInvalidPassword(String password) {
        if (password.equals(null)){
            return true;
        }
        return false;
    }

    private boolean isContainsEmail(String email) {
        if (userProfileMap.containsKey(email)){
            return true;
        }
        return false;
    }

    private boolean containsInvalidEmail(String email) {
        if (email.equals(null)){
            return true;
        }
        return false;
    }

    private boolean containsInvalidChar(String name) {
        if (name.equals(null)){
            return true;
        }else if (name.length()<5){
            return true;
        }
        return false;
    }

}
