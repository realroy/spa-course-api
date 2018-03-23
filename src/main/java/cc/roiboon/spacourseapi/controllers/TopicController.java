package cc.roiboon.spacourseapi.controllers;

import cc.roiboon.spacourseapi.models.Topic;
import cc.roiboon.spacourseapi.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

  @Autowired
  ResourceService<Topic> resourceService;

  @GetMapping
  public List<Topic> getAll() {
    return resourceService.all();
  }

  @GetMapping(value = "/{id}")
  public Object getById(@PathVariable String id) {
    Topic t = resourceService.getById(id);
    return t != null ? t : new ArrayList<Topic>();
  }

  @PostMapping
  public Object create(@RequestBody Topic topic) {
    resourceService.create(topic);
    return new ArrayList<Topic>();
  }

  @PutMapping(value = "/{id}")
  public Object update(@PathVariable String id, @RequestBody Topic topic) {
    resourceService.updateById(id, topic);
    return new ArrayList<Topic>();
  }

  @DeleteMapping(value = "/{id}")
  public Object deleteById(@PathVariable String id) {
    resourceService.deleteById(id);
    return new ArrayList<Topic>();
  }
}
