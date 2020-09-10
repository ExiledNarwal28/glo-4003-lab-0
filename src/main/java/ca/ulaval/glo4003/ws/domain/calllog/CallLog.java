package ca.ulaval.glo4003.ws.domain.calllog;

public class CallLog {
  private String id;
  private String telephoneNumber;
  private String date;
  private int durationInSeconds;

  public CallLog(String telephoneNumber, String date, int durationInSeconds) {
    this.telephoneNumber = telephoneNumber;
    this.date = date;
    this.durationInSeconds = durationInSeconds;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public String getDate() {
    return date;
  }

  public int getDurationInSeconds() {
    return durationInSeconds;
  }
}
