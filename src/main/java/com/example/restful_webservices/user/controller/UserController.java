package com.example.restful_webservices.user.controller;
import com.example.restful_webservices.user.exception.UserNotFoundEception;
import com.example.restful_webservices.user.model.User;
import com.example.restful_webservices.user.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Created by gsati on 8/22/2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public Resource getUser(@PathVariable int id){
        User user = userDaoService.findUser(id);
        if(user == null)
            throw new UserNotFoundEception("id-" +id + " not found");
        Resource<User> resource = new Resource<>(user);
       ControllerLinkBuilder controllerLinkBuilder =
               ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());
            resource.add(controllerLinkBuilder.withRel("To get all-users"));
        return resource;
    }
    @RequestMapping(path = "/userAll", method = RequestMethod.GET)
    public List<User> getUsers(){
      List<User> list =   userDaoService.getAll();
        return list;
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public HttpStatus getUser(@RequestBody User user){
        User save = userDaoService.saveUser(user);
        return HttpStatus.ACCEPTED;

    }

    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        User save = userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(save.getId())
               .toUri();
        return ResponseEntity.created(location).build();

    }

    @RequestMapping(path = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        User user2 = userDaoService.deleteUser(id);
        if (user2 == null) {
            throw new UserNotFoundEception("id-" + id + " not found");
        }
    }
}
