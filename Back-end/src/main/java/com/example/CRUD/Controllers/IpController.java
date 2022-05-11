package com.example.CRUD.Controllers;

import com.example.CRUD.JavaUtils.HttpUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ClientIP")
@CrossOrigin()
public class IpController
{
    @GetMapping
    public ipReturn getClientIPAddress(HttpServletRequest request) {
        String ip = HttpUtils.getRequestIP(request);
        ipReturn response = new ipReturn(ip);
        return response;
    }
}

class ipReturn
{
    public String ip;

    public ipReturn(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}