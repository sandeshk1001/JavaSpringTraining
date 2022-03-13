
/*
POJO - Plain old Java Object
The Database operations and other logic are all there in this
single controller. DAO Pattern
DAO - Data access object
DAO Pattern  is to decouple the logic of database from the controller.
Its good design practice to separate the Database logic and remaining controller logic
or take out the databse related operations out of the controller.
Benefits
(i) It avoid duplicate code
(ii) Code resuability
(iii) Database related operations are put in a separate class of their own.
So any changes to Dao classes don't affect the classes that use it
(iv) Decouples the Database logic with other logic
Ex:
(i) Do the same for Tweet or other Entity classes you have made
 */

 Have added one more Exercise :
 (ii) Try to make a single Dao interface and make the
 UserDaoImpl , TweetDaoImpl implement this single interface.
 (If you have other name apart from user or tweet use appropriately)

 Do it after doing the Ex (I) Observe that the multiple interfaces have the same methods inside it.
 Use Template to have only one interface rather than a separate interface for Each Entity

We will break as of now and connect tomorrow. I have pushed the code with common interface you can go over it and we will discuss it tomorrow.
I will most likely cover Streams and git commands tomorrow and whatever doubts you have till now.
https://forms.gle/P6XozU9X8PHRavXe9
You can submit this form and write your doubts there.


I will be sharing an assessment soon.
Till then you can do a small exercise:
(i) create a git repository
(ii) add some files to it and make a commit
(iii) add some new file to it and do git checkout -b A
(iv) commit that new file in this new branch
(v) make a new branch say B from A and add some files into it.
(vi) add few files in B and do commit
(viii) Merge B into master
(ix) push the changes remotely on GitHub.com
(x) When you push the changes on GitHub.com there will be a option you will see on top saying pull request/compare. Create a pull request between branch A and B
(xi) Submit this pull request url
