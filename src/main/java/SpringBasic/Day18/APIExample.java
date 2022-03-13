package SpringBasic.Day18;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import utils.Utility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
<div>
    {{#users}}
        <h3>{{email}}</h3>
    {{/users}}
</div>
users = [{"email":"a@gmail.com"},{"email":"b@gmail.com"},{"email":"c@gmail.com"}]
Template and data are merged or combined to finally produce and html
After processing of this template and data we will have the following HTML
<div>
        <h3>a@gmail.com</h3>
        <h3>b@gmail.com</h3>
        <h3>c@gmail.com</h3>
</div>
 */

public class APIExample {

//    private Map<String, User> userProfileMap = new HashMap<>();
//    private Map<String, List<Tweet>> tweetsMap = new HashMap<>();
//    private Map<String, List<String>> followmap = new HashMap<>();
//    @Autowired
//    Dao<User> userDao;
//    Dao<Tweet> tweetDao;
////    private UserDao userDao;
////    @Autowired
////    private TweetDao tweetDao;
//    /*
//       Template Engine -> Mustache, JSP, Thymeleaf
//     */
//
//    /*--------------------------------------------------
//    -------------------users api----------------------
//     ------------------------------------------------*/
//    public APIExample() {
//    }
//
//    @GetMapping("/user/register")
//    public ModelAndView openregiter(){
//        ModelAndView modelAndView = new ModelAndView("register");
//        return modelAndView;
//    }
//
//    // login api
////    @GetMapping("/user/loginForm")
////    public ModelAndView getLoginForm(){
////        ModelAndView modelAndView = new ModelAndView("loginForm");
////        return modelAndView;
////    }
//
////    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
////    public ModelAndView login(@RequestBody MultiValueMap<String, String> formData) {
////        if (!isUserValid(formData)) {
////            System.out.println("Wrong credential");
////            return errorMessageModelAndView("Wrong credentials");
////        }
////        ModelAndView modelAndView = new ModelAndView("profile");
////        String email = formData.get("email").get(0);
////        String name = userProfileMap.get(email).getName();
////        modelAndView.getModel().put("name", name);
////        modelAndView.getModel().put("email", email);
////        modelAndView.getModel().put("password", userProfileMap.get(email).getPassword());
////        return modelAndView;
////    }
////
////    private boolean isUserValid(MultiValueMap<String, String> map) {
////        String email = map.get("email").get(0);
////        String password = map.get("password").get(0);
////        User user = userProfileMap.get(email);
////        if (user.getPassword().equals(password))
////            return true;
////        return false;
////    }
//
//    private ModelAndView errorMessageModelAndView(String message) {
//        ModelAndView modelAndView = new ModelAndView("error");
//        System.out.println("message: "+message);
//        modelAndView.getModel().put("message", message);
//        return modelAndView;
//    }
//
////     show all users on users mustache file -->GET
//    @GetMapping("user/displayUserDetail")
//    public ModelAndView getUserList(){
//        ModelAndView modelAndView=new ModelAndView("userslist");
//        if (userProfileMap.isEmpty())
//            allAccDetails();
//        List<User> userList=new ArrayList<>();
//        for (Map.Entry entry:userProfileMap.entrySet()){
//            userList.add((User) entry.getValue());
//        }
//        modelAndView.getModel().put("users",userList);
//        return modelAndView;
//    }
//
//    @PostMapping( value = "/user/createuser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ModelAndView getRegiseteredData(@RequestBody MultiValueMap<String, String> formData){
//        if (formData.isEmpty()){
//            return errorMessageModelAndView(new ResponseEntity<>("No such data",HttpStatus.BAD_REQUEST).toString());
//        }
//        String name=formData.get("name").get(0);
//        String email=formData.get("email").get(0);
//        String password=formData.get("password").get(0);
//        return errorMessageModelAndView(createUser(new User(name,email,password)).toString());
//    }
//
////     create a new user --> POST
//    @PostMapping("/user/createUser")
//    private ResponseEntity<String> createUser(@RequestBody User user){
//        ResponseEntity<String> responseEntity=null;
//        String name=user.getName();
//        String email=user.getEmail();
//        String password=user.getPassword();
//        if (containsInvalidChar(name))
//            responseEntity=new ResponseEntity<>("name contains invalid character",HttpStatus.BAD_REQUEST);
//        else if (containsInvalidEmail(email) || isContainsEmail(email)){
//            responseEntity=new ResponseEntity<>("Email contains invalid character or alerady present",HttpStatus.BAD_REQUEST);
//        }else if(containsInvalidPassword(password)){
//            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
//        }else {
//            userDao.create(user);
//            userProfileMap.put(email,user);
//            responseEntity=new ResponseEntity<>("Registered successfully",HttpStatus.OK);
//        }
//        return responseEntity;
//    }
//
//    // fecth all users -->GET
//    @GetMapping("/user/fetchUsers")
//    @ResponseBody
//    Map<String, User> allAccDetails() {
//        userProfileMap.clear();
//        List<User> list =userDao.readAll();
//        for (User user:list)
//            userProfileMap.put(user.getEmail(),user);
//        System.out.println("userlist :"+userProfileMap);
//        return userProfileMap;
//    }
//
//    /*--------------------------------------------------
//    -------------------tweets api----------------------
//     ------------------------------------------------*/
//
//    // open new tweet for web  --> POST
////    @PostMapping(value = "/tweet/newtweet", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
////    public ModelAndView geNewTweetData(@RequestBody MultiValueMap<String, String> formData){
////        ResponseEntity<String> responseEntity=null;
////        String email = formData.get("email").get(0);
////        String password = formData.get("password").get(0);
////        String tweet =formData.get("tweet").get(0);
////        String name = userProfileMap.get(email).getName();
////        if (tweet.equals(null)){
////            responseEntity =new ResponseEntity<>("tweet contains null value",HttpStatus.BAD_REQUEST);
////            return errorMessageModelAndView(responseEntity.getBody()+" Status Code:"+responseEntity.getStatusCode());
////        }
////        Tweet tweetobj =new Tweet(name,email,tweet,LocalDateTime.now());
////        getUserTweets(email);
////        responseEntity= postTweet(tweetobj,password);
////        return errorMessageModelAndView(responseEntity.getBody()+"...... Status Code:"+responseEntity.getStatusCode());
////    }
//
////    @PostMapping("/posttweet")
////    @ResponseBody
////    ResponseEntity<String> postTweet(@RequestBody Tweet tweet, @RequestParam String password){
////        ResponseEntity<String> responseEntity =null;
////        String name=tweet.getName();
////        String email=tweet.getEmail();
////        String t = tweet.getTweet();
////        tweet.setLocalDateTime(LocalDateTime.now());
////        if(t.equals(null)){
////            responseEntity=new ResponseEntity<>("Tweet is contains null value",HttpStatus.BAD_REQUEST);
////        }else if (containsInvalidChar(name)){
////            responseEntity=new ResponseEntity<>("name contains invalid",HttpStatus.BAD_REQUEST);
////        }else if (!isContainsEmail(email)){
////            responseEntity=new ResponseEntity<>("Email contains invalid character or not present",HttpStatus.BAD_REQUEST);
////        }else if(!isPasswordMatch(email,password)){
////            responseEntity=new ResponseEntity<>("Password not match",HttpStatus.BAD_REQUEST);
////        }else {
////            Session session =Utility.getSessionAnotation(Tweet.class);
////            Transaction transaction = session.beginTransaction();
////            if (tweetsMap.containsKey(email)){
////                tweetsMap.get(email).add(tweet);
////                session.persist(tweet);
////                responseEntity=new ResponseEntity<>("Tweet added",HttpStatus.OK);
////            }else{
////                List<Tweet> tweetList=new ArrayList<>();
////                tweetList.add(tweet);
////                session.persist(tweet);
////                tweetsMap.put(email, tweetList);
////                responseEntity=new ResponseEntity<>("Tweet added",HttpStatus.OK);
////            }
////            transaction.commit();
////            session.close();
////        }
////        return responseEntity;
////    }
////
////    // show all tweets on showtweets musthache file - GET
////    @GetMapping("/tweet/showtweets")
////    public ModelAndView getUserTweets(@RequestParam String email){
////        ResponseEntity<String> responseEntity=null;
////        ModelAndView modelAndView =new ModelAndView("showtweets");
////        if (tweetsMap.isEmpty())
////            fetchTweets();
////        if (!tweetsMap.containsKey(email)){
////            responseEntity =new ResponseEntity<>("Email not exist",HttpStatus.NOT_ACCEPTABLE);
////            return errorMessageModelAndView(responseEntity.getBody()+"...... Status Code:"+responseEntity.getStatusCode());
////        }
////        List<Tweet> tweetList=usersTweetsList(email);
////        modelAndView.getModel().put("username", tweetsMap.get(email).get(0).getName());
////        modelAndView.getModel().put("tweetscount", tweetList.size());
////        modelAndView.getModel().put("showtweets", tweetList);
////        return modelAndView;
////    }
////
////    /**
////     * @method GET
////     * @use using that we can get the all tweet of the pass email of the user
////     * @param email
////     * @return tweetlist of the user
////     */
////    @GetMapping("/tweet/usertweetslist")
////    @ResponseBody
////    private List<Tweet> usersTweetsList(@RequestParam String email){
////        ResponseEntity<String> responseEntity =null;
////        if (!isContainsEmail(email)){
////            responseEntity=new ResponseEntity<>("Email not present",HttpStatus.BAD_REQUEST);
////        }else if(tweetsMap.containsKey(email)){
////                return tweetsMap.get(email);
////                //responseEntity=new ResponseEntity<>("Tweets are :\n"+tweetsMap.get(email)+"\n",HttpStatus.OK);
////            }else {
////                responseEntity=new ResponseEntity<>("Pasword not match",HttpStatus.NOT_ACCEPTABLE);
////            }
////        return new ArrayList<>();
////        }
////
////    // this for on postman --> GET
////    @GetMapping("/tweet/usertweets")
////    @ResponseBody
////    private ResponseEntity<String> allTweets(@RequestParam String email,@RequestParam String password){
////        fetchTweets();
////        ResponseEntity<String> responseEntity =null;
////        if (!isContainsEmail(email)){
////            responseEntity=new ResponseEntity<>("Email not present",HttpStatus.BAD_REQUEST);
////        }else if(containsInvalidPassword(password)){
////            responseEntity=new ResponseEntity<>("Password contains invalid character",HttpStatus.BAD_REQUEST);
////        }else{
////            if (isPasswordMatch(email,password)){
////                responseEntity=new ResponseEntity<>("Tweets are :\n"+tweetsMap.get(email)+"\n",HttpStatus.OK);
////            }else {
////                responseEntity=new ResponseEntity<>("Pasword not match",HttpStatus.NOT_ACCEPTABLE);
////            }
////        }
////        return responseEntity;
////    }
////
////    // fecth all tweet --> get
////    @GetMapping("/tweet/fetchtweets")
////    @ResponseBody
////    Map<String, List<Tweet>> fetchTweets() {
////        Session session = Utility.getSessionAnotation(Tweet.class);
////        List<Object[]> list = session.createQuery("select name,email,tweet,localDateTime from TweetTable ", Object[].class).getResultList();
////        for (int i = 0; i < list.size(); i++) {
////            Object[] arr = list.get(i);
////            Tweet tweet = new Tweet(arr[0].toString(), arr[1].toString(), arr[2].toString(), (LocalDateTime) arr[3]);
////            String email = arr[1].toString();
////            if (tweetsMap.containsKey(email)) {
////                tweetsMap.get(email).add(tweet);
////            } else {
////                List<Tweet> tweetList = new ArrayList<>();
////                tweetList.add(tweet);
////                tweetsMap.put(arr[1].toString(), tweetList);
////            }
////        }
////        session.close();
////        return tweetsMap;
////    }
////
////    @PostMapping("/tweet/followfriend")
////    private ResponseEntity<String> followFriend(@RequestBody Map<String,String> requestbody){
////        String email=requestbody.get("email");
////        String password=requestbody.get("password");
////        String friendEmail=requestbody.get("friendemail");
////        ResponseEntity<String> responseEntity=null;
////        if (!isContainsEmail(email) || !isContainsEmail(friendEmail)){
////            responseEntity=new ResponseEntity<>("Email not contain",HttpStatus.BAD_REQUEST);
////        }else if (!isPasswordMatch(email,password)){
////            responseEntity=new ResponseEntity<>("Password incorrect",HttpStatus.NOT_ACCEPTABLE);
////        }else if(email.equals(friendEmail)){
////            responseEntity=new ResponseEntity<>("Same mail can't added",HttpStatus.NOT_ACCEPTABLE);
////        }else{
////            if(followmap.containsKey(email)){
////                User user=userProfileMap.get(friendEmail);
////                followmap.get(email).add(user.getEmail());
////                System.out.println(followmap);
////                responseEntity=new ResponseEntity<>("Friend Added"+followmap.get(email),HttpStatus.OK);
////            }else{
////                List<String> friendlist=new ArrayList<>();
////                friendlist.add(userProfileMap.get(friendEmail).getEmail());
////                followmap.put(email,friendlist);
////                System.out.println(followmap);
////                responseEntity=new ResponseEntity<>("Friend Added"+followmap.get(email),HttpStatus.OK);
////            }
////        }
////        return responseEntity;
////    }
////
////    /*--------------------------------------------------
////    -------------------validation methods---------------
////     ------------------------------------------------*/
//    private boolean containsInvalidPassword(String password) {
//        if (password==null)
//            return true;
//        return false;
//    }
//
//    private boolean containsInvalidChar(String name) {
//        if (name == null) {
//            return true;
//        }else if(name.length()>5){
//            return false;
//        }
//        return true;
//    }
//
//    private boolean containsInvalidEmail(String email) {
//        if(email==null)
//            return true;
//        return false;
//    }
//
//    private boolean isPasswordMatch(String email,String password) {
//        User user = userProfileMap.get(email);
//        if (user.getPassword().equals(password)) {
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    private Boolean isContainsEmail(String email) {
//        if (userProfileMap.containsKey(email))
//            return true;
//        return false;
//    }

}
