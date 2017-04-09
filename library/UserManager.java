import java.util.*;
public class UserManager{
    ArrayList<User> userList = new ArrayList<>();

    void run(){
        User user = this.create("田所浩二","男",24);
        this.add(user);
        user = this.create("金正日","男",69);
        this.add(user);
        user = this.create("エア本","女",55);
        this.add(user);
        user = this.create("KRSW","男",39);
        this.add(user);
        user = this.create("金正恩","男",24);
        this.add(user);

        List<User> users = this.find("KRSW","男",69);
        this.printList(users);

        users = this.find("麻原彰晃","女",69);
        this.printList(users);
    }

    User create(String name,String gender,Integer age){
        User user = new User();
        user.name = name;
        user.gender = gender;
        user.age = age;
        return user;
    }

    void printList(List<User> users){
        for(User user: users){
            this.print(user);
        }
    }

    void print(User user){
        System.out.println(user.name +":"+ user.gender +","+ user.age);
    }

    Integer size(){
        return userList.size();
    }

    void add(User user){
        userList.add(user);
    }

    List<User> find(String name,String gender,Integer age){
        ArrayList<User> result = new ArrayList<>();
        for(User user: userList){
            if(this.isOrMatch(user,name,gender,age)){
                result.add(user);
            }
        }
        return result;
    }

    Boolean isOrMatch(User user,String name,String gender,Integer age){
        Boolean flag = false;
        if(Objects.equals(user.name,name)) flag = true;
        if(Objects.equals(user.gender,gender)) flag = true;
        if(user.age == age ) flag = true;
        return flag;
    }

    Boolean delete(User user){
        return userList.remove(user);
    }

    public static void main(String[] args){
        UserManager um = new UserManager();
        um.run();
    }
}
