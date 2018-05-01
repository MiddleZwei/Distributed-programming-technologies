package com.webappdatabase.controller;

import com.webappdatabase.model.Resource;
import com.webappdatabase.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/resources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addResource(@RequestBody Resource resource){
        resourceService.addResource(resource);
    }

    @RequestMapping(value = "/resources/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addResource(@RequestBody Resource resource, @PathVariable String id){
        resourceService.updateResource(id, resource);
    }

    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE)
    public void deleteResource(@PathVariable String id){
        resourceService.deleteResource(id);
    }

}
