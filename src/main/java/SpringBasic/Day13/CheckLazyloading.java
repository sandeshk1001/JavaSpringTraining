package SpringBasic.Day13;

import SpringBasic.Day12.Dependencies_Injection_Sorting.BubbleSort;
import SpringBasic.Day12.Dependencies_Injection_Sorting.MergeSort;
import SpringBasic.Day12.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

public class CheckLazyloading {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyConfiguration.class,args);
        System.out.println("Check LazyLoading how its work");
        BubbleSort bubbleSort = context.getBean(BubbleSort.class);
        MergeSort mergeSort = context.getBean(MergeSort.class);
        bubbleSort.sort(new ArrayList<>());
        mergeSort.sort(new ArrayList<>());
        System.out.println("Which is fast");
//        check("URDR");
    }
//    static int check(String s){
//        Map<Character,Integer> c =new HashMap<>();
//        for (int i=0;i<s.length();i++){
//            if(c.containsKey(s.charAt(i))){
//                c.put(s.charAt(i),c.get(s.charAt(i))+1);
//            }else{
//                c.put(s.charAt(i),1);
//            }
//        }
//        System.out.println(c);
//        int U,R,D,L;
//        U= c.containsKey('U') ? c.get('U') : 0;
//        L=c.containsKey('L') ? c.get('L') : 0;
//        D=c.containsKey('D') ? c.get('D') : 0;
//        R=c.containsKey('R') ? c.get('R') : 0;
//        int UD=U-D;
//        int RL=R-L;
//        int result= ((U+D)-UD)+((R+L)-RL);
//
//        return result;
//    }
}
/*
    we applied lazy-init true
 */
/*
Ex= Tweeter Api example
(ii)
https://www.twiter.com/tweet/post
{"tweetId"=101,"tweetTitle"="Tweet-1","TweetMessage"="wansdkwjendand",
"TweetUser":{"userId":758,"userName":"xyz"}}
(i)
https://www.twiter.com/post
{"name":"userName",""email":"emailId",}

(iii)
https://www.twiter.com/fetch?alltweet

Ex= facebook API Example

(i) create user
https://www.facebook.com/createuser         POST
{
    "userName":"",
    "address":{},
    "age": ,
    "educationDetails":[],
    "profilePic":
}

(ii) show profile
https://www.facebook.com/users?userId=101       GET
{
   usersDetail:
    {   "userName":  ,
        "UserProfile":  ,
        "age":  ,
        "educationDetails":  ,
        "address:{}
    }
}
(iii) Add friend
https://www.facebook.com//addfriend                 PUT
{
    "userId":"" ,
    "friendUserId": ""
}

(iv) friends of another user
https://www.facebook.com//friendlist?userid=101         GET
{
    "friendlist":[user1,user2,user3,user4]
}

(v) post
https://www.facebook.com//posts?userId=101     GET
{
    "postlist":[post1,post2,post3]
}

(vi) likes
https://www.facebook.com//like          PUT
{
    "userId":"",
    "postid":""
}
 */