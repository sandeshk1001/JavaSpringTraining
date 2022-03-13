package SpringBasic.Day18.project.Dao;

import Day18.project.Tweet;

import java.util.List;

public interface TweetDao {
    List<Tweet> readAll();
    void create(Tweet tweet);
    List<Tweet> fetchTweets(String email);
    void update(Tweet tweet);
    void delete(Tweet tweet);
}
