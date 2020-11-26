package org.example.restapi.controller;

import com.google.gson.Gson;
import org.example.database.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.restapi.rabbitmq.*;
import org.example.database.model.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public final RestApiRecv restApiReceive = new RestApiRecv();
    public final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    // -------------------Get an User-------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        try {
            RestApiSend.getUser(Long.toString(id));
            restApiReceive.RecvDataUser();
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        finally {
            return new ResponseEntity<>(restApiReceive.getDatamessage(), HttpStatus.OK);
        }
    }

    // -------------------Login-------------------------------------------

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            RestApiSend.login(new Gson().toJson(user));
            restApiReceive.RecvLoginMsg();
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        finally{
            return new ResponseEntity<>(restApiReceive.getLoginmessage(), HttpStatus.OK);
        }


    }

    // -------------------Logout-------------------------------------------

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public ResponseEntity<?> logoutUser() {
        try {
            RestApiSend.logout();
            restApiReceive.RecvLogoutMsg();
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        finally{
            return new ResponseEntity<>(restApiReceive.getLogoutmessage(), HttpStatus.OK);
        }



    }

    // -------------------Register-------------------------------------------

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            RestApiSend.register(new Gson().toJson(user));
            restApiReceive.RecvRegMsg();
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        finally {
            return new ResponseEntity<>(restApiReceive.getRegistermessage(), HttpStatus.OK);
        }


    }


}