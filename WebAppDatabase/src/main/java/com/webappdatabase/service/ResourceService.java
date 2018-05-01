package com.webappdatabase.service;

import com.webappdatabase.model.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ResourceService {

    private List<Resource> resources = new ArrayList<>(Arrays.asList(
            new Resource("1", "name1", "content1"),
                new Resource("2", "name2", "content2"),
                new Resource("3", "name3", "content3"),
                new Resource("4", "name4", "content4")
        ));

    public List<Resource> getAllResources(){
        return resources;
    }

    public Resource getResource(Long id){
        return resources.stream().filter(r -> r.getId().equals(id)).findFirst().get();
    }


    public void addResource(Resource resource){
        resources.add(resource);
    }

    public void updateResource(String id, Resource resource) {
        for (int i = 0; i < resources.size(); i++){
            Resource r_temp = resources.get(i);
            if (r_temp.getId().toString().equals(id)){
                resources.set(i, resource);
                return;
            }
        }
    }

    public void deleteResource(String id) {
        resources.removeIf(r -> r.getId().toString().equals(id));
    }
}
