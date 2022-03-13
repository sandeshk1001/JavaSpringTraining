package SpringBasic.Day14;
/*
(i) The URL (ii) HTTP Method (iii) Request Body (iv) Response Body (v) Query Parameters
Ex :
Twitter HTTP APIs
Suppose if there 10k tweets. There will lot of network payload
which will result in delay
(i) Which can fetch tweets in batches of 100.
(ii) We also want the ability to fetch the tweets by data in ascending or descending order
(iii) API should be configurable and you can ask for say 100 , 200 tweets
(iv) Design the HTTP API call for the next button. Which will show the next
100 tweets
(v) Design the HTTP API call for the prev button. Which will show the prev
100 tweets
(vi) Design the HTTP API with the page number.
HTTP API should be able to fullfill all the above requirements.
------
Return all tweets
*/
/*
    (i)&(iii)&(iv) fetch 100 batches
    https://www.twiter.com/fetch?numberoftweet=100&tweetid=id           GET
    fecth data next tweetid to 100 numberoftweet
    tweet =[tweet1,tweet2........tweet100]
    next
    tweet=[tweet101,tweet102.......tweet200]

    (ii) fetch asec
    https://www.twiter.com/fetch?type=asec



    (v) fetch prev
    https://www.twiter.com/fetchprev?numberoftweet=100&tweetid=id


 */



/*
Ex:
Facebook HTTP APIs
--------------------
1) User account creation
2) Follow another user
3) Friend another user
4) unfriend another user
5) post
6) likes
 */
public class Main {
}
