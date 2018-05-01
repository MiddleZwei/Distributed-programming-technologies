package com.webappdatabase.service;

import com.webappdatabase.model.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ResourceService {

    private List<Resource> resources = Arrays.asList(
            new Resource("1", "name1", "content1"),
                new Resource("2", "name2", "content2"),
                new Resource("3", "name3", "content3"),
                new Resource("4", "name4", "content4")
        );

    public List<Resource> getAllResources(){
        return resources;
    }

    public Resource getResource(Long id){
        return resources.stream().filter(r -> r.getId().equals(id)).findFirst().get();
    }

}
