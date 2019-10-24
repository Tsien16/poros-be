package com.tsien.poros.controller;

import com.tsien.poros.dao.ResourceDAO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Resource
    private ResourceDAO resourceDAO;

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
    public LocalDateTime hello21() {
        return LocalDateTime.now();
    }

    @GetMapping("hello2")
    public LocalDate hello212() {
        return LocalDate.now();
    }

    @PutMapping("hello1")
    public String hello13() {
        return "Hello";
    }

}
