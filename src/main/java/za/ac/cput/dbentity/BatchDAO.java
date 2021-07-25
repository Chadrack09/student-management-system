package za.ac.cput.dbentity;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 14:51:05
 */
public class BatchDAO {
  private String id;
  private String batchNumber;
  private String year;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }  
}