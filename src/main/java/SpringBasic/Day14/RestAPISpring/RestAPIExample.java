package SpringBasic.Day14.RestAPISpring;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
///*
//GET, POST, PUT
//HTTP request and it is returning a response.
//Especially in this case it is non - GUI
//It's returning some data
//HTTP API which you call and it returns some data it is also called
//REST API
//domain/ -> Get request and it has to return all the tweets
//http://localhost:8080/tweets GET
//These requests are handled by Tomcat server
//(i) http://localhost:8080/tweets    GET
//
//(ii) http://localhost:8080/tweets?mention=sandesh     GET
//    using queryparam
//
//(iii)http://localhost:8080/tweets?mention=sandesh&word=abcdefg
//    using 2 queryparam
//
// (iv) http://localhost:8080/tweets?mention=sandesh&word=message&body=sdcnndsmcmx cjd
//        using number of param
//        we store this no of param in map and convert all value into list and return the list
//
// (v)
// */
//
//@RestController
public class RestAPIExample {
////    @GetMapping("/tweets")
////    List<String> getTweets(){
////        return Arrays.asList("tweet-1","tweet-2","tweet-3");
////    }
////    @GetMapping("/filtertweets")
////    List<String> getTweets(@RequestParam String mention){
////        return Arrays.asList(mention);
////    }
////    @GetMapping("/tweets")
////    List<String> getTweets(@RequestParam String mention,@RequestParam String word){
////        return Arrays.asList(mention,word);
////    }
//
//    /*-------------------------------------------------
//      -------------------Twiter----------------------
//     ------------------------------------------------*/
//    @GetMapping("tweet/tweets")
//    List<String> getTweets(@RequestParam Map<String,String> body){
//        List<String> stringList =new ArrayList<>();
//        body.entrySet().forEach(entry->stringList.add(entry.getValue()));
//        return stringList;
//    }
///*
// 1) User can create an account
// *Requenst = http://localhost:8080/createuser  POST
//             {"name":"user-1","email":"hello@gmail.com"}
// *Response = "{\"name\":\"user-1\",\"email\":\"hello@gmail.com\"}"
//*/
//    @PostMapping("tweet/createuser")
//    List<String> createUser(@RequestBody String body){
//        return Arrays.asList(body);
//    }
///*
//2) User can fetch account details
//https://localhost:8080/fetchuser?email=tim@gmail.com  GET
// */
//    @GetMapping("tweet/fetchuser")
//    List<String> userDetails(@RequestParam String email){
//        return Arrays.asList(email);
//    }
///*
//(3) A new tweet is posted
//https://localhost:8080/tweet/posttweet   POST
//{
//"userID":"",
//"tweet":"content of tweet"
//}
// */
//    @PostMapping("tweet/posttweet")
//    List<String> postTweet(@RequestBody String body) {
//        return Arrays.asList(body);
//    }
///*
//(iii) Return all tweets
//https://localhost/alltweet?userId=123   GET
//{"tweets":["tweet1","tweet2","tweet2"]}
// */
//    @GetMapping("tweet/alltweets")
//    List<String> getAllTweets(@RequestParam String userId){
//        return Arrays.asList("tweet-1","tweet-2","tweet-3");
//    }
}
