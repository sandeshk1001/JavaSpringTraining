package SpringBasic.Day14.RestAPISpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class TwiterRestAPIExample {
    private HashMap<Integer, HashMap<String,String>> userprofile = new HashMap<>();
    private HashMap<String,List<String>> tweets=new HashMap<>();
    private static int count=0;

    @PostMapping("tweet/createuser")
    private ResponseEntity<String> createUser(@RequestBody Map<String,String> requestbody){
        String name=requestbody.get("name");
        String email=requestbody.get("email");
        ResponseEntity<String> responseEntity =null;
        if(containsInvalidChar(name)){
            responseEntity=new ResponseEntity<>("Name contains invalid characters", HttpStatus.BAD_REQUEST);
        }else if(containsInvalidEmail(email)){
            responseEntity=new ResponseEntity<>("email contains invalid characters", HttpStatus.BAD_REQUEST);
        }else{
            HashMap<String,String> detail = new HashMap<>();
            detail.put("name",name);
            detail.put("email",email);
            userprofile.put(count=count+1,detail);
            responseEntity=new ResponseEntity<>("Registered successfully", HttpStatus.OK);
            System.out.println(userprofile);
        }
        return responseEntity;
    }

    @GetMapping("tweet/userdetail")
    private ResponseEntity<String> userlist(@RequestParam String userid){
        ResponseEntity<String> responseEntity = null;
        if (userid.equals(null)){
            responseEntity=new ResponseEntity<>("userid is null",HttpStatus.BAD_REQUEST);
        }else{
            responseEntity =new ResponseEntity<>(""+Arrays.asList("UserId="+userid+" "+userprofile.get(Integer.parseInt(userid))),HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("tweet/updateuser")
    private ResponseEntity<String> updateuser(@RequestParam Map<String,String> requestmap){
        String name=requestmap.get("name");
        String email=requestmap.get("email");
        ResponseEntity<String> responseEntity=null;
        if (containsInvalidChar(name)){
            responseEntity=new ResponseEntity<>("Name conatins invalid character",HttpStatus.BAD_REQUEST);
        }else{
            int value=isContainsEmail(email);
            if (value ==0){
                responseEntity=new ResponseEntity<>("Email not contains",HttpStatus.BAD_REQUEST);
            }else{
                userprofile.get(value).put("name",name);
                System.out.println(userprofile);
                responseEntity=new ResponseEntity<>("Update successfully",HttpStatus.OK);
            }
        }
        return responseEntity;
    }

    private Integer isContainsEmail(String email) {
        for(int i=1;i<=userprofile.size();i++)
        {
            if (email.equals(userprofile.get(i).get("email")))
                return i;
        }
        return 0;
    }

    private boolean containsInvalidChar(String name) {
        if (name == null) {
            return true;
        }else if(name.length()>5){
            return false;
        }
        return true;
    }

    private boolean containsInvalidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(email);
        if(email==null){
            return true;
        }else if(m.matches()){
//            Boolean check;
//            userprofile.entrySet().forEach(entry->check=email.equals(entry.getValue("email")));
            for(int i=1;i<=userprofile.size();i++)
            {
                if (email.equals(userprofile.get(i).get("email")))
                    return true;
            }
            return false;
        }
        return true;
    }

    private boolean isEmailExist(String email){
        for(int i=1;i<=userprofile.size();i++)
        {
            if (email.equals(userprofile.get(i).get("email")))
                return true;
        }
        return false;
    }
}
