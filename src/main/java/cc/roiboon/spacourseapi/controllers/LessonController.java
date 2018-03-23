package cc.roiboon.spacourseapi.controllers;

import cc.roiboon.spacourseapi.models.Lesson;
import cc.roiboon.spacourseapi.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LessonController {

  private final String BASE_URL = "/lessons";

  @Autowired
  LessonService service;

  @GetMapping(BASE_URL)
  public List<Lesson> getAll() {
    return service.all();
  }

  @GetMapping(BASE_URL + "/{id}")
  public Object getById(@PathVariable String id) {
    return service.getById(id);
  }

  @PostMapping(BASE_URL)
  public Object create(@RequestBody Lesson lesson) {
    return service.create(lesson);
  }

  @PutMapping(BASE_URL + "/{id}")
  public Object update(@PathVariable String id, @RequestBody Lesson lesson) {
    return service.updateById(id, lesson);
  }

  @DeleteMapping(BASE_URL + "/{id}")
  public Object deleteById(@PathVariable String id) {
    return service.deleteById(id);
  }

  @GetMapping("/course/{id}" + BASE_URL)
  public List<Lesson> getByCourseId(@PathVariable String id) {
    return service.getByCourseId(id);
  }

  @GetMapping("/course/{courseId}" + BASE_URL + "/{lessonId}")
  public List<Lesson> getByCourseAndLessonId(@PathVariable String courseId, @PathVariable String lessonId) {
    return service
        .all()
        .parallelStream()
        .filter(x -> x.getCourse().getId().equals(courseId))
        .filter(x -> x.getId().equals(lessonId))
        .collect(Collectors.toList());
  }

  @GetMapping("/topic/{topicId}/course/{courseId}" + BASE_URL)
  public List<Lesson> getByTopicAndCourseId(@PathVariable String topicId, @PathVariable String courseId) {
    return service
        .all()
        .parallelStream()
        .filter(x -> x.getCourse().getId().equals(courseId))
        .filter(x -> x.getCourse().getTopic().getId().equals(topicId))
        .collect(Collectors.toList());
  }

  @GetMapping("/topic/{topicId}/course/{courseId}" + BASE_URL + "/{lessonId}")
  public List<Lesson> getByTopicCourseAndLessonId(@PathVariable String topicId, @PathVariable String courseId, @PathVariable String lessonId) {
    return service
        .all()
        .parallelStream()
        .filter(x -> x.getCourse().getId().equals(courseId))
        .filter(x -> x.getCourse().getTopic().getId().equals(topicId))
        .filter(x -> x.getId().equals(lessonId))
        .collect(Collectors.toList());
  }
}
