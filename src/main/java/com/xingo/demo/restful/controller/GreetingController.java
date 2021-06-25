package com.xingo.demo.restful.controller;

import com.xingo.demo.base.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author FangJiHao
 * @date 2021/6/25 14:28
 * @version 1.0
 */
@RestController
public class GreetingController {

    public static final String TEMPLATE = "Hello,%s";
    public final AtomicLong counter = new AtomicLong(10L);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name) {
        return new Greeting(this.counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
