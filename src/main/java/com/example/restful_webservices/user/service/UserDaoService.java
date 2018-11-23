package com.example.restful_webservices.user.service;
import com.example.restful_webservices.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gsati on 8/22/2018.
 */
@Component
public class UserDaoService {
    private static int count=3;
    private static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User(1,"sats",new Date()));
        userList.add(new User(2,"gun",new Date()));
        userList.add(new User(3,"shiv",new Date()));
    }
    public List<User> getAll(){
        return userList;
    }

    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++count);
        }
        userList.add(user);
        return user;

    }
    public User findUser(int id){

       for(User user: userList){
           if(user.getId()==id)
               return user;
       }
        return null;
    }
    public User deleteUser(int id){
            Iterator<User> iterator= userList.iterator();
            while(iterator.hasNext()){
                User user = iterator.next();
                if(user.getId()==id) {
                    iterator.remove();
                    return user;
                }
            }

        return null;
    }
}
