package com.tsien.poros.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 15:11
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello1() {
        return "Hello";
    }

    @PostMapping("hello")
    public String hello2() {
        return "Hello";
    }

    @PutMapping("hello")
    public String hello3() {
        return "Hello";
    }

    @DeleteMapping("hello")
    public String hello4(@RequestParam(value = "name") String name) {
        return "Hello" + name;
    }

    @GetMapping("hello1")
    public String hello21() {
        return "Hello1";
    }

    @PutMapping("hello1")
    public String hello13() {
        return "Hello";
    }

}
