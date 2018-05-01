package com.webappdatabase.controller;

import com.webappdatabase.model.Resource;
import com.webappdatabase.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/resources")
    public List<Resource> getAllTopics(){
        return resourceService.getAllResources();
    }

    @RequestMapping("/resources/{id}")
    public Resource getResource(@PathVariable String id){
        return resourceService.getResource(Long.parseLong(id));
    }

}
