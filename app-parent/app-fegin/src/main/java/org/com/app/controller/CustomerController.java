package org.com.app.controller;

import org.com.app.base.entry.Result;
import org.com.app.model.Demo;
import org.com.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello() {
        return demoService.sayHello();
    }

    @GetMapping("/sayHelloDemo")
    public String sayHelloDemo() {
        return demoService.sayHello();
    }

    @GetMapping("/get1/{name}")
    public Result add(@PathVariable("name") String name) {
        return demoService.add(name);
    }

    @GetMapping("/get2")
    public Result add(Demo demo) {
        return demoService.add(demo);
    }

    @PostMapping("/post1")
    public Result post(String name) {
        return demoService.post(name);
    }

    @PostMapping("/post2")
    public Result post(Demo demo) {
        return demoService.post(demo);
    }

    @PostMapping("/post3")
    public Result body(@RequestBody Demo demo) {
        return demoService.body(demo);
    }
}
