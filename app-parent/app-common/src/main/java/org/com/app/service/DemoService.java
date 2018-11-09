package org.com.app.service;

import org.com.app.base.entry.Result;
import org.com.app.model.Demo;
import org.com.app.service.Impl.DemoServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "app-provider-user",fallback = DemoServiceFallBackFactory.class)
public interface DemoService {
    @GetMapping("/provider/sayHello")
     String sayHello();

    @GetMapping("/provider/sayHelloDemo")
    String sayHelloDemo();

    @GetMapping("/provider/get/{name}")
     Result add(@PathVariable("name") String name);

    @GetMapping("/provider/get2")
     Result add(Demo demo);

    @PostMapping("/provider/post1")
     Result post(String name);

    @PostMapping("/provider/post2")
     Result post(Demo demo);

    @PostMapping("/provider/post3")
     Result body(@RequestBody Demo demo);
}
