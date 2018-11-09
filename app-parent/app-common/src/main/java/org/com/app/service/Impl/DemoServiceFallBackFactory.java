package org.com.app.service.Impl;

import org.com.app.base.entry.Result;
import org.com.app.model.Demo;
import org.com.app.service.DemoService;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceFallBackFactory implements DemoService {
    @Override
    public String sayHello() {
        return "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭";
    }

    @Override
    public String sayHelloDemo() {
        return "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭";
    }

    @Override
    public Result add(String name) {
        return Result.utils.setFailResult("该：" + name + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
    }

    @Override
    public Result add(Demo demo) {
        return null;
    }

    @Override
    public Result post(String name) {
        return null;
    }

    @Override
    public Result post(Demo demo) {
        return null;
    }

    @Override
    public Result body(Demo demo) {
        return null;
    }
}
