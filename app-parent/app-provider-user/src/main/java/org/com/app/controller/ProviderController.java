package org.com.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.com.app.base.entry.Result;
import org.com.app.base.exception.CustomerException;
import org.com.app.model.Demo;
import org.com.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProviderController extends BaseController{
    @Autowired
    private DiscoveryClient client;

    @Autowired
    DemoService demoService;

    @GetMapping("/sayHello")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String sayHello() {
        /*throw new CustomerException("abc");*/
        return "Hello";
    }

    @GetMapping("/datatest")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String datatest() {
        JSONObject jsonObject=getJsonObject();
        /*throw new CustomerException("abc");*/
        return jsonObject.toString();
    }
/*   public String processHystrix_Get() {
        return "该没有没有对应的信息,null--@HystrixCommand";
    }*/
    @GetMapping("/sayHelloDemo")
    public String sayHelloFeigen(){
       return demoService.sayHello();
    }
    @GetMapping("/get/{name}")
    //@HystrixCommand(fallbackMethod = "hystrix1")
    public Result add(@PathVariable("name") String name) {
        return Result.utils.setSuccessResult(new Demo().setDemoName(name).insert());
    }
/*    public Result hystrix1(String name) {
        return Result.utils.setFailResult("该没有没有对应的信息,null--@HystrixCommand");
    }*/

    @GetMapping("/get2")
    public Result add(Demo demo) {
        return Result.utils.setSuccessResult(demo);
    }

    @PostMapping("/post1")
    public Result post(String name) {
        return Result.utils.setSuccessResult(name);
    }

    @PostMapping("/post2")
    public Result post(Demo demo) {
        return Result.utils.setSuccessResult(demo);
    }

    @PostMapping("/post3")
    public Result body(@RequestBody Demo demo) {
        return Result.utils.setSuccessResult(demo);
    }


    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
