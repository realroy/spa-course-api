package cc.roiboon.spacourseapi.controllers;

import cc.roiboon.spacourseapi.models.Course;
import cc.roiboon.spacourseapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

  private final String BASE_URL = "/courses";

  @Autowired
  CourseService service;

  @GetMapping(BASE_URL)
  public List<Course> getAll() {
    return service.all();
  }

  @GetMapping(BASE_URL + "/{id}")
  public Object getById(String id) {
    return service.getById(id);
  }

  @PostMapping(BASE_URL)
  public Object create(@RequestBody Course course) {
    return service.create(course);
  }

  @PutMapping(BASE_URL + "/{id}")
  public Object update(@PathVariable String id,@RequestBody Course course) {
    return service.updateById(id, course);
  }

  @DeleteMapping(BASE_URL + "/{id}")
  public Object deleteById(@PathVariable String id) {
    return service.deleteById(id);
  }

  @GetMapping("/topic/{id}" + BASE_URL)
  public List<Course> getByTopicId(@PathVariable String id) {
    return service.findByTopicId(id);
  }

  @GetMapping("/topic/{topicId}" + BASE_URL + "/{courseId}")
  public List<Course> getByTopicAndCourseId(@PathVariable String topicId, @PathVariable String courseId) {
    return service.findByTopicAndCourseId(topicId, courseId);
  }

}
