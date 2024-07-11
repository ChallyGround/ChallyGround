package com.chally.ChallyGround;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value="/test")
    public String sampleHome() {
        return "test.html";
    }
}
