package cc.roiboon.spacourseapi.services;


import cc.roiboon.spacourseapi.models.Course;
import cc.roiboon.spacourseapi.models.Topic;
import cc.roiboon.spacourseapi.repositories.CourseRepository;
import cc.roiboon.spacourseapi.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService implements ResourceService<Course> {

  @Autowired
  private CourseRepository repository;

  @Override
  public List<Course> all() {
    List<Course> list = new ArrayList<>();
    repository
        .findAll()
        .forEach(list::add);
    return list;
  }

  @Override
  public Course getById(String id) {
    return repository
        .findById(id)
        .orElse(null);
  }

  @Override
  public boolean create(Course c) {
    try {
      repository.save(c);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean updateById(String id, Course c) {
    try{
      repository.save(c);
      return true;
    }catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean deleteById(String id) {
    try {
      repository.deleteById(id);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public List<Course> findByTopicId(String topicId) {
    return repository.findByTopicId(topicId);
  }

  public List<Course> findByTopicAndCourseId(String topicId, String courseId) {
    return all()
        .parallelStream()
        .filter(x -> x.getTopic().getId().equals(topicId))
        .filter(x -> x.getId().equals(courseId))
        .collect(Collectors.toList());
  }

}
