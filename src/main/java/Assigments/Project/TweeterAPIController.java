package Assigments.Project;

import Assigments.Project.Dao.Dao;
import Assigments.Project.Dao.TweetImplement;
import Assigments.Project.ModelClasses.AddFriend;
import Assigments.Project.ModelClasses.Tweet;
import Assigments.Project.ModelClasses.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TweeterAPIController {
    @Autowired
    Dao<User> UserDao;

    @Autowired
    Dao<Tweet> PostDao;

    @Autowired
    Dao<AddFriend> AddFriendDao;

    TweetImplement postImplement=new TweetImplement();

    public static ModelAndView errorMessageModelAndView(String message) {
        ModelAndView modelAndView = new ModelAndView("Project/error");
        modelAndView.getModel().put("error", message);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView openRegister(){
        ModelAndView modelAndView=new ModelAndView("register");
        return modelAndView;
    }

    /**
     * @USE create a new user
     * @param formData
     * @return response model
     */
    @PostMapping( value = "/createuser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView getRegiseteredData(@RequestBody MultiValueMap<String, String> formData){
        if (formData.isEmpty()){
            return errorMessageModelAndView(new ResponseEntity<>("No such data", HttpStatus.BAD_REQUEST).toString());
        }
        String name=formData.get("name").get(0);
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        String visibilty=formData.get("visibilty").get(0);
        User user=new User(name,email,password,visibilty);
        List<User> list = UserDao.readAll().stream().filter(user1 -> user1.getEmail()== user1.getEmail()).collect(Collectors.toList());
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || visibilty.isEmpty()){
            return errorMessageModelAndView("Field is not emppty".toString());
        }else if (list.size()==0){
            UserDao.create(user);
            return errorMessageModelAndView("Registrered".toString());

        }else {
            return errorMessageModelAndView("User already registered".toString());

        }
    }

    @GetMapping("/login")
    public ModelAndView openLogin(){
        ModelAndView modelAndView=new ModelAndView("loginForm");
        return modelAndView;
    }

    /**
     * @USE create a new user
     * @param formData
     * @return response model
     */
    @PostMapping( value = "/checklogin", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView CheckLogin(@RequestBody MultiValueMap<String, String> formData){
        if (formData.isEmpty()){
            return errorMessageModelAndView(new ResponseEntity<>("No such data", HttpStatus.BAD_REQUEST).toString());
        }
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        List<User> list = UserDao.readAll().stream().filter(user1 -> user1.getEmail() == user1.getEmail()).collect(Collectors.toList());
        if (email.isEmpty() || password.isEmpty()){
            return errorMessageModelAndView("Field is not emppty".toString());
        }else if (list.size()!=0){
            User user=UserDao.readByEmail(email);
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                ModelAndView modelAndView = new ModelAndView("profile");
                modelAndView.getModel().put("name", user.getName());
                modelAndView.getModel().put("email", user.getEmail());
                modelAndView.getModel().put("password", user.getPassword());
                return modelAndView;
            }else{
                return errorMessageModelAndView("user is not present".toString());
            }
        }else {
            return errorMessageModelAndView("User already registered".toString());
        }
    }


    @GetMapping("/mytweet")
    public ModelAndView openmytweet(){
        ModelAndView modelAndView=new ModelAndView("loginForm");
        return modelAndView;
    }


    @PostMapping(value = "/newpost", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addPost(@RequestBody MultiValueMap<String, String> postBody) {
        String email=postBody.get("email").get(0);
        String password=postBody.get("password").get(0);
        String postString = postBody.get("tweet").get(0);
        User user = UserDao.readByEmail(email);
        if (isUserValid(postBody)) {
            Tweet post = new Tweet(postString, LocalDateTime.now(), user);
            PostDao.create(post);
            return errorMessageModelAndView("Successfully added");
//            ModelAndView modelAndView = new ModelAndView("success-post");
//            return modelAndView;
        }
        return errorMessageModelAndView("Data mis match");
    }

    private boolean isUserValid(MultiValueMap<String, String> postBody) {
        return true;
    }

    //     show all users on users mustache file -->GET
    @GetMapping("/showmytweet")
    public ModelAndView getUsermypost(@RequestParam String email){
        ModelAndView modelAndView=new ModelAndView("showtweets");
        User user=UserDao.readByEmail(email);
        System.out.println("users :"+user);
        List<Tweet> tweetList =postImplement.readByEmailallpost(user.getId());
        System.out.println("allPost :"+tweetList);
        if (tweetList.size()==0){
            return errorMessageModelAndView("There is not tweet");
        }
        System.out.println("allPost :"+tweetList);
        modelAndView.getModel().put("tweets",tweetList);
        modelAndView.getModel().put("name",user.getName());
        return modelAndView;
    }
    /*----------------------validation ------------------------------*/

    boolean containsInvalidPassword(String password) {
        if (password.equals(null))
            return true;
        return false;
    }

    boolean isContainsEmail(String email) {
        return false;
    }

    boolean isPasswordMatch(String email,String password){
        return false;
    }

    boolean containsInvalidEmail(String email) {
        if (email.equals(null))
            return true;
        return false;
    }

    boolean containsInvalidChar(String name) {
        if (name.equals(null))
            return true;
        return false;
    }

}