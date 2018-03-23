package cc.roiboon.spacourseapi.repositories;

import cc.roiboon.spacourseapi.models.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String>{
  List<Lesson> getByCourseId(String courseId);
}
