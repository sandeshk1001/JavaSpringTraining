package SpringBasic.Day20.Restapi;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
/*
Ex:
(i) Make a POST request and fetch the response
from any POST API on reqres.in
documentation for RestTemplate :
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
 */
@RestController
public class TestController {
    @PostMapping("/")
    public JsonNode test(@RequestBody Map<String ,String> data) {
        System.out.println("Inside testController");
        RestTemplate restTemplate =new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        List<String> value = new ArrayList<>();
        value.add("application/json");
        httpHeaders.put("content-type",value);
        HttpEntity<JsonNode> entity= new HttpEntity<>(httpHeaders);
//        Map<String ,String> map=new HashMap<>();
//        map.put("name","xyz");
//        map.put("jab","leader");
        ResponseEntity<JsonNode> responseEntity=restTemplate.exchange("https://reqres.in/api/users/create",
                HttpMethod.POST,entity,JsonNode.class,data);
//        ResponseEntity<JsonNode> responseEntity=restTemplate.exchange("https://reqres.in/api/users",
//                HttpMethod.GET,entity,JsonNode.class);
        return  responseEntity.getBody();
    }
}
