package TaskSpring_12March.FacebookAPI;

import TaskSpring_12March.FacebookAPI.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FacebookAPIController {
    @Autowired
    Dao<FbUser> fbUserDao;

    @Autowired
    Dao<FbPost> fbPostDao;

    @Autowired
    Dao<FbAddFriend> fbAddFriendDao;

    private Map<String, FbUser> fbUserProfileMap = new HashMap<>();
    private Map<String, List<FbPost>> fbpostmap = new HashMap<>();
    private Map<String, List<FbAddFriend>> fbfollowmap = new HashMap<>();

    //using of that we can open login page
    @GetMapping(value="fb/user/login")
    public ModelAndView openLogin(){
        ModelAndView modelAndView = new ModelAndView("fb/fblogin");
        return modelAndView;
    }

    //using of that we can open registration page
    @GetMapping(value="fb/user/registration")
    public ModelAndView openRegister(){
        ModelAndView modelAndView = new ModelAndView("fb/fbregistration");
        return modelAndView;
    }


    //     show all users on users mustache file -->GET
    @GetMapping("fb/user/displaymypost")
    public ModelAndView getUsermypost(@RequestParam String email){
        ModelAndView modelAndView=new ModelAndView("fb/mypost");
        List<FbPost> postList = getFbPostbyuserEmail(email);
        System.out.println("allPost :"+postList);
        if (postList.isEmpty() || !fbpostmap.containsKey(email))
            return errorMessageModelAndView("Wrong credentials");
        modelAndView.getModel().put("posts",postList);
        return modelAndView;
    }

    @PostMapping(value="fb/user/loginCheck", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView checkLogin(@RequestBody MultiValueMap<String, String> formData){
        ModelAndView modelAndView=null;
            if (!isUserValid(formData) || formData.isEmpty()) {
            System.out.println("Wrong credential");
            return errorMessageModelAndView("Wrong credentials");
            }
            modelAndView = new ModelAndView("fb/fbprofile");
            String email = formData.get("email").get(0);
            String name = fbUserProfileMap.get(email).getName();
            modelAndView.getModel().put("name", name);
            modelAndView.getModel().put("email", email);
            modelAndView.getModel().put("password", fbUserProfileMap.get(email).getPassword());
            modelAndView.getModel().put("post",getFbPostbyuserEmail(email));
        return modelAndView;
    }

    private boolean isUserValid(MultiValueMap<String, String> map) {
        getAllFbUsers();
        String email = map.get("email").get(0);
        String password = map.get("password").get(0);
        FbUser user = fbUserProfileMap.get(email);
        if (user.getPassword().equals(password))
            return true;
        return false;
    }

    @PostMapping( value = "fb/user/createuser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView getRegiseteredData(@RequestBody MultiValueMap<String, String> formData){
        if (formData.isEmpty()){
            return errorMessageModelAndView(new ResponseEntity<>("No such data",HttpStatus.BAD_REQUEST).toString());
        }
        String name=formData.get("name").get(0);
        String email=formData.get("email").get(0);
        String password=formData.get("password").get(0);
        return errorMessageModelAndView(createUser(new FbUser(name,email,password)).toString());
    }

    private ModelAndView errorMessageModelAndView(String message) {
        ModelAndView modelAndView = new ModelAndView("fb/error");
        System.out.println("message: "+message);
        modelAndView.getModel().put("message", message);
        return modelAndView;
    }

    /*----------------users API----------------------------------------*/

    /**
     * @USE using that fatch all the fb user
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/user/fecthAllUser")
    public  Map<String ,FbUser> getAllFbUsers(){
        fbUserProfileMap.clear();
        List<FbUser> list = fbUserDao.readAll();
        for (FbUser user:list)
            fbUserProfileMap.put(user.getEmail(),user);
        System.out.println("allpost:"+fbUserProfileMap);
        return fbUserProfileMap;
    }

    /**
     * @USE using that fatch the fb user by id
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/user/fecthUserdetail")
    public FbUser getFbUserById(@RequestParam int id){
        return fbUserDao.readById(id);
    }

    /**
     * @USE using that fatch the fb user by id
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/user/fecthUserDetailByEmail")
    public int getFbUserByEmail(@RequestParam String email){
        getAllFbUsers();
        return (int)fbUserProfileMap.get(email).getId();
    }

    /**
     * @USE using that we can create user web and postman both
     * @param user
     * @return responseEntity
     * @METHOD POST
     */
    @PostMapping("/user/createUser")
    private ResponseEntity<String> createUser(@RequestBody FbUser user){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String name=user.getName();
        String email=user.getEmail();
        String password=user.getPassword();
        if (containsInvalidChar(name))
            responseEntity=new ResponseEntity<>("name contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or alerady present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else {
            fbUserDao.create(user);
            fbUserProfileMap.put(email,user);
            responseEntity=new ResponseEntity<>("Registered successfully",HttpStatus.OK);
        }
        return responseEntity;
    }

    /**
     * @USE using that we can update user web and postman both
     * @param user
     * @return responseEntity
     * @METHOD POST
     */
    @PostMapping("fb/user/updateUser")
    private ResponseEntity<String> updateUser(@RequestBody FbUser user){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String name=user.getName();
        String email=user.getEmail();
        String password=user.getPassword();
        if (containsInvalidChar(name))
            responseEntity=new ResponseEntity<>("name contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || !isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or alerady present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else {
            if(fbUserDao.update(user)) {
                fbUserProfileMap.put(email, user);
                responseEntity = new ResponseEntity<>("Update successfully", HttpStatus.OK);
            }else
                responseEntity = new ResponseEntity<>("Something wrong", HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }

    /**
     * @USE using that we can update user web and postman both
     * @param user
     * @return responseEntity
     * @METHOD POST
     */
    @PostMapping("fb/user/deleteUser")
    private ResponseEntity<String> deleteUser(@RequestBody FbUser user){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String name=user.getName();
        String email=user.getEmail();
        String password=user.getPassword();
        user =fbUserProfileMap.get(email);
        if (containsInvalidChar(name))
            responseEntity=new ResponseEntity<>("name contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || !isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or not present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else {
            fbUserDao.delete(user);
            fbUserProfileMap.remove(email, user);
            responseEntity = new ResponseEntity<>("Delete successfully", HttpStatus.OK);
//            responseEntity = new ResponseEntity<>("Something wrong", HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }


    /*-------------------------post API-------------------------------*/

    /**
     * @USE using that fatch all the fb user
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/post/fecthAllPost")
    public Map<String ,List<FbPost>> getAllFbPost(){
        fbpostmap.clear();
        List<FbPost> list = fbPostDao.readAll();
        for (FbPost post:list){
            String email=post.getFbUser().getEmail();
            if(fbpostmap.containsKey(email)){
                fbpostmap.get(email).add(post);
            }
            else {
                List<FbPost> postList =new ArrayList<>();
                postList.add(post);
                fbpostmap.put(email,postList);
            }
        }
        return fbpostmap;
    }

    /**
     * @USE using that fatch all the fb user
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/post/fecthPostbyId")
    public FbPost getFbPostbyuserId(@RequestParam int id){
        return fbPostDao.readById(id);
    }

    /**
     * @USE using that fatch all the fb user by email
     * @return user map
     * @METHOD GET
     */
    @GetMapping("/fb/post/fecthPostbyEmail")
    public List<FbPost> getFbPostbyuserEmail(@RequestParam String email){
        getAllFbPost();
        return fbpostmap.get(email);
    }


    /**
     * @Use using that we can add new post
     * @param fbpost
     * @param email
     * @param password
     * @return response
     * @METHOD POST
     */
    @PostMapping("/POST/createPost")
    private ResponseEntity<String> createPost(@RequestBody FbPost fbpost, @RequestParam String email,String password){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String post=fbpost.getPost();
        if (containsInvalidChar(post))
            responseEntity=new ResponseEntity<>("Post contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || !isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or not present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else if(isPasswordMatch(email, password)) {
            if (fbpostmap.containsKey(email)){
                fbpost.setFbUser(fbUserProfileMap.get(email));
                fbpost.setLocalDateTime(LocalDateTime.now());
                fbPostDao.create(fbpost);
                fbpostmap.get(email).add(fbpost);
            }else{
                fbpost.setFbUser(fbUserProfileMap.get(email));
                fbpost.setLocalDateTime(LocalDateTime.now());
                fbPostDao.create(fbpost);
                List<FbPost> list=new ArrayList<>();
                list.add(fbpost);
                fbPostDao.create(fbpost);
                fbpostmap.put(email,list);
                responseEntity=new ResponseEntity<>("Post added successfully",HttpStatus.OK);
            }
        }else
            responseEntity=new ResponseEntity<>("Password incorrect",HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    /**
     * @USE using that we can update user web and postman both
     * @param post
     * @return responseEntity
     * @METHOD POST
     */
    @PostMapping("fb/post/deletePost")
    private ResponseEntity<String> deletePost(@RequestBody FbPost post){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String postt= post.getPost();
        String email=post.getFbUser().getEmail();
        if (containsInvalidChar(postt))
            responseEntity=new ResponseEntity<>("name contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || !isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or not present",HttpStatus.BAD_REQUEST);
        }else {
            fbPostDao.delete(post);
            responseEntity = new ResponseEntity<>("Delete successfully", HttpStatus.OK);
        }
        return responseEntity;
    }

    /**
     * @Use using that we can add update post
     * @param fbpost
     * @param email
     * @param password
     * @return response
     * @METHOD POST
     */
    @PostMapping("/post/updatePost")
    private ResponseEntity<String> updatePost(@RequestBody FbPost fbpost, @RequestParam String email,String password){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String post=fbpost.getPost();
        if (containsInvalidChar(post))
            responseEntity=new ResponseEntity<>("Post contains invalid character", HttpStatus.BAD_REQUEST);
        else if (containsInvalidEmail(email) || !isContainsEmail(email)){
            responseEntity=new ResponseEntity<>("Email contains invalid character or not present",HttpStatus.BAD_REQUEST);
        }else if(containsInvalidPassword(password)){
            responseEntity=new ResponseEntity<>("Password contains invalid",HttpStatus.BAD_REQUEST);
        }else if(isPasswordMatch(email, password)) {
            if (fbpostmap.containsKey(email)){
                fbpost.setFbUser(fbUserProfileMap.get(email));
                fbPostDao.create(fbpost);
                fbpostmap.get(email).add(fbpost);
            }else{
                fbpost.setFbUser(fbUserProfileMap.get(email));
                fbPostDao.create(fbpost);
                List<FbPost> list=new ArrayList<>();
                list.add(fbpost);
                fbPostDao.create(fbpost);
                fbpostmap.put(email,list);
                responseEntity=new ResponseEntity<>("Post added successfully",HttpStatus.OK);
            }
        }else
            responseEntity=new ResponseEntity<>("Password incorrect",HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    /*----------------------- follow friend-----------------------------*/

    @PostMapping("/addfriend")
    private ResponseEntity<String> addFriend(@RequestBody Map<String ,String> mapdata){
        getAllFbUsers();
        ResponseEntity<String> responseEntity=null;
        String email=mapdata.get("email");
        String friendEmail=mapdata.get("friendEmail");
        FbUser fbUser =fbUserProfileMap.get(email);
        FbUser fbfriendUser =fbUserProfileMap.get(friendEmail);
        if (!isContainsEmail(email) || !isContainsEmail(friendEmail))
            responseEntity=new ResponseEntity<>("Email not registered",HttpStatus.NOT_ACCEPTABLE);
        else{
            FbAddFriend fbAddFriend = new FbAddFriend(fbUser,fbfriendUser);
            if (fbfollowmap.containsKey(email)){
                fbfollowmap.get(email).add(fbAddFriend);
            }else{
                List<FbAddFriend> list=new ArrayList<>();
                list.add(fbAddFriend);
                fbfollowmap.put(email,list);
            }
            responseEntity=new ResponseEntity<>("friend added",HttpStatus.OK);
        }
        return responseEntity;
    }

    /*----------------------validation ------------------------------*/

    boolean containsInvalidPassword(String password) {
        if (password.equals(null))
            return true;
        return false;
    }

    boolean isContainsEmail(String email) {
        if (fbUserProfileMap.containsKey(email))
            return true;
        return false;
    }

    boolean isPasswordMatch(String email,String password){
        if(fbUserProfileMap.get(email).getPassword().equals(password))
            return true;
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
