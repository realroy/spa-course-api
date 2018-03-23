package cc.roiboon.spacourseapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lesson implements Model {
  @Id
  private String id;
  private String name;
  private String description;

  @ManyToOne
  private Course course;

  public Lesson() {}

  public Lesson(String id, String name, String description, Course course) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.course = course;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Lesson{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", course=" + course +
        '}';
  }
}
