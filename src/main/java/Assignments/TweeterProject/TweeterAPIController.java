package Assignments.TweeterProject;

import Assignments.TweeterProject.Dao.Dao;
import Assignments.TweeterProject.Exception.CommanException;
import Assignments.TweeterProject.ModelClasses.AddFriend;
import Assignments.TweeterProject.ModelClasses.Tweet;
import Assignments.TweeterProject.ModelClasses.User;
import Assignments.TweeterProject.Utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Assignments.TweeterProject.Utils.Utility.isContainsEmail;
import static Assignments.TweeterProject.Utils.Utility.validateUser;

@RestController
public class TweeterAPIController {

    @Autowired
    Dao<User> UserDao;

    @Autowired
    Dao<Tweet> PostDao;

    @Autowired
    Dao<AddFriend> AddFriendDao;

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
            throw new CommanException("No such data ",HttpStatus.BAD_REQUEST);
        }
        String name=formData.get("name").get(0);
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        String visibilty=formData.get("visibilty").get(0);
        User user=new User(name,email,password,visibilty);
        List<User> list=UserDao.readAll().stream().filter(user1 ->user1.getEmail().equals(user.getEmail())).collect(Collectors.toList());
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || visibilty.isEmpty()){
            throw new CommanException("Field is Empty",HttpStatus.BAD_REQUEST);
        }else if (list.size()==0){
            UserDao.create(user);
            throw new CommanException("User registered",HttpStatus.OK);
        }else {
            throw new CommanException("User already Registered",HttpStatus.FORBIDDEN);
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
            return Utility.errorMessageModelAndView(new ResponseEntity<>("No such data", HttpStatus.BAD_REQUEST).toString());
        }
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        List<User> list = UserDao.readAll().stream().filter(user1 -> user1.getEmail() == user1.getEmail()).collect(Collectors.toList());
        if (email.isEmpty() || password.isEmpty()){
            throw new CommanException("Field is Empty",HttpStatus.BAD_REQUEST);
        }else if (list.size()!=0){
            User user=UserDao.readByEmail(email);
            if(Utility.validateUser(email,password)){
                ModelAndView modelAndView = new ModelAndView("profile");
                modelAndView.getModel().put("name", user.getName());
                modelAndView.getModel().put("email", user.getEmail());
                modelAndView.getModel().put("password", user.getPassword());
                return modelAndView;
            }else{
                throw new CommanException("Wrong Credentials",HttpStatus.BAD_REQUEST);
            }
        }else {
            throw new CommanException("User already registered",HttpStatus.BAD_REQUEST);
        }
    }

    /*--------------------- Tweet -----------------------------*/
    @GetMapping("/mytweet")
    public ModelAndView openmytweet(){
        ModelAndView modelAndView=new ModelAndView("loginForm");
        return modelAndView;
    }

    @PostMapping(value = "/newtweet", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addTweet(@RequestBody MultiValueMap<String, String> postBody) {
        String email=postBody.get("email").get(0);
        String password=postBody.get("password").get(0);
        String postString = postBody.get("tweet").get(0);
        User user = UserDao.readByEmail(email);
        if (validateUser(email, password)) {
            Tweet post = new Tweet(postString, LocalDateTime.now(), user);
            PostDao.create(post);
            throw new CommanException("Tweet Added",HttpStatus.OK);
        }
        throw new CommanException("Wrong credentials",HttpStatus.OK);
    }

    //     show all users on users mustache file -->GET
    @GetMapping("/showmytweet")
    public ModelAndView getUsermypost(@RequestParam String email){
        ModelAndView modelAndView=new ModelAndView("showtweets");
        User user=UserDao.readByEmail(email);
        System.out.println("users :"+user);
        List<Tweet> tweetList =PostDao.readAll().stream()
                        .filter(t -> t.getFbUser().getId() == user.getId())
                        .collect(Collectors.toList());
        modelAndView.getModel().put("tweets",tweetList);
        modelAndView.getModel().put("tweetscount",tweetList.size());
        modelAndView.getModel().put("username",user.getName());
        return modelAndView;
    }
    /*----------------------follow ------------------------------*/

    @PostMapping( value = "/addfriend", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private ModelAndView addFriend(@RequestBody Map<String ,String> mapdata){
        ResponseEntity<String> responseEntity=null;
        String email=mapdata.get("email");
        String friendEmail=mapdata.get("friendEmail");
        String password = mapdata.get("password");
        User fbUser =UserDao.readByEmail(email);
        User fbfriendUser =UserDao.readByEmail(friendEmail);
        if (!isContainsEmail(email) || !isContainsEmail(friendEmail))
            throw new CommanException("Email not registered",HttpStatus.BAD_REQUEST);
        else if(fbUser.getPassword().equals(password)){
            List<AddFriend> list = AddFriendDao.readAll().stream().filter(fbAddFriend -> fbAddFriend.getFriendId()==fbfriendUser.getId()).collect(Collectors.toList());
            if (list.size()==0){
                AddFriend fbAddFriend = new AddFriend(fbfriendUser.getId(),fbUser,false);
                AddFriendDao.create(fbAddFriend);
                throw new CommanException("Friend added",HttpStatus.BAD_REQUEST);
            }else{
                throw new CommanException("You both are already friend",HttpStatus.BAD_REQUEST);
            }
        }
        throw new CommanException("Wrong credential",HttpStatus.BAD_REQUEST);
    }

    @PostMapping( value = "/removefriend", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private ModelAndView removeFriend(@RequestBody Map<String ,String> mapdata){
        ResponseEntity<String> responseEntity=null;
        String email=mapdata.get("email");
        String friendEmail=mapdata.get("friendEmail");
        String password = mapdata.get("password");
        User fbUser =UserDao.readByEmail(email);
        User fbfriendUser =UserDao.readByEmail(friendEmail);
        if (!isContainsEmail(email) || !isContainsEmail(friendEmail))
            throw new CommanException("Email not registered",HttpStatus.BAD_REQUEST);
        else if(fbUser.getPassword().equals(password)){
            List<AddFriend> list = AddFriendDao.readAll().stream().filter(fbAddFriend -> fbAddFriend.getFriendId()==fbfriendUser.getId()).collect(Collectors.toList());
            if (list.size()!=0){
                AddFriend fbAddFriend = new AddFriend(fbfriendUser.getId(),fbUser,false);
                AddFriendDao.delete(fbAddFriend);
                throw new CommanException("Friend deleted",HttpStatus.BAD_REQUEST);
            }else{
                throw new CommanException("You both are not a friend",HttpStatus.BAD_REQUEST);
            }
        }
        throw new CommanException("Wrong credential",HttpStatus.BAD_REQUEST);
    }

}