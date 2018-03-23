package cc.roiboon.spacourseapi.repositories;

import cc.roiboon.spacourseapi.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String>{
  List<Course> findByTopicId(String topicId);
}
