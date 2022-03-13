When you create a new user, take into account the password too.
You can extend your code with the following:
Each time a user makes a request, send a password too in the request.
Only return response if it's a correct password.
So inside your method, you will check if its a valid password or not by looking into your User objects
and error response If its invalid, otherwise proceed with the normal flow of execution



<property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
Use this in your hibernate.cfg.xml file This is basically the dialect for mysql version 8 features.
the earlier one seems to be creating some issues when used with MySQLDialect
This will resolve some of the hibernate related errors that you are getting and also will enable automatic creation of tables



/*
User login, making tweets.
Reference:
(i) Form Tag in HTML (for making http request from web page)
https://www.w3schools.com/tags/tag_form.asp
(ii) Tag to be used when making a tweet
 https://www.w3docs.com/snippets/html/how-to-create-a-multi-line-text-input-field-in-html.html
(iii) Manual for Mustache. This explains all the different kind of keyword available in mustache.
Like {{}}, {{#}},...
https://mustache.github.io/mustache.5.html
Ex:
(i) Make an API that list down all the tweets of a user.
You can pass email or id in the query params
(ii) Make a separate HTML page having a button. Which when clicked
takes to the (i) API so that it automatically lists down the tweets of the user.
(iii) Make a simple login page with two fields for entering username and password
and a button. When button is clicked there is either an error in case of invalid password
or it takes to the list of all tweets that the user has made.
(iv) Provide a field on tweets page to create a new tweet.
This will need a field and a button to create which will link
to the already written api for creating a tweet
(v) Provide a button to create a new user on the login page which when clicked
takes to another page where user can enter name and password
 */
I have added some code to RestAPIExample.
@GetMapping("/loginForm")
@PostMapping(value="/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
Some files under templates folder
The API's can be used for login. Try running it and putting this url in chrome :
http://localhost:8080/loginForm

 I have pushed one more change. Check it out.
 Now there is a tweets button once the user logs in and when you click on it all
 the tweet by the user will get displayed
 If you are done doing this then it's fine, otherwise you can use this code
 and try to understand it
