package com.rum.ksc_back.Controller;

import com.rum.ksc_back.Config.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Essay")
public class EssayController {
    public Request homing(){

        return new Request("1",null);
    }
}
