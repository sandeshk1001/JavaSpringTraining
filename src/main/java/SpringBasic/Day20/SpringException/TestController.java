package SpringBasic.Day20.SpringException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public void test(String id) throws TweetNotFound2 {
        System.out.println("inside controller");
        throw new TweetNotFound2();
    }
}
