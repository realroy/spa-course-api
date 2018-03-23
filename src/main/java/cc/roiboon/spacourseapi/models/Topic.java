package cc.roiboon.spacourseapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic implements Model {
  @Id
  private String id;
  private String name;
  private String description;

  Topic() {}

  public Topic(String id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
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

  @Override
  public String toString() {
    return "Topic{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
