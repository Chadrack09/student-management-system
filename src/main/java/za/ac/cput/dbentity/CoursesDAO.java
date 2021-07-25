package za.ac.cput.dbentity;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 03:29:26
 */
public class CoursesDAO {
  private String id; 
  private String courseName;
  private String duration;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  
  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Courses{" + "courseName=" + courseName + ", duration=" + duration + '}';
  }  
}