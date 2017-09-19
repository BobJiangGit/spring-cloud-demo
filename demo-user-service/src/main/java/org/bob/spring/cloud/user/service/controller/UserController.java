package org.bob.spring.cloud.user.service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bob Jiang on 2017/9/19.
 */
@RestController
public class UserController {

    @RequestMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id) {
        return "name: bob, id: " + id;
    }

}
