import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeTableRow {
    private String stationShortCode;
    private Integer stationUICCode;
    private String countryCode;
    private String type;
    private boolean trainStopping;
    private Date scheduledTime;
    private Date actualTime;


    @Override
    public String toString() { // tekee päivämääristä ja ajoista luettavat suomalaiseen silmään
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ssZ");
        String formatoituAika = df.format(scheduledTime);

        return "TimeTableRow{" +
                "stationShortCode='" + stationShortCode + '\'' +
                ", type='" + type + '\'' +
                ", trainStopping=" + trainStopping +
                ", scheduledTime=" + formatoituAika +
                ", actualTime=" + actualTime +
                '}';
    }

    public String getStationShortCode() {
        return stationShortCode;
    }

    public void setStationShortCode(String stationShortCode) {
        this.stationShortCode = stationShortCode;
    }

    public Integer getStationUICCode() {
        return stationUICCode;
    }

    public void setStationUICCode(Integer stationUICCode) {
        this.stationUICCode = stationUICCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTrainStopping() {
        return trainStopping;
    }

    public void setTrainStopping(boolean trainStopping) {
        this.trainStopping = trainStopping;
    }

    public String getFormatoituScheduledTime() {
//        SimpleDateFormat
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formatoituAika = df.format(scheduledTime);
        return formatoituAika;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Optional<String> getFormatoituActualTime() {
//        SimpleDateFormat
        SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if (actualTime != null) {
            String formatoituAika2 = df2.format(actualTime);
            return Optional.of(formatoituAika2);
        }
        return Optional.empty();
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }
}
