
package com.takata.retrofitjava;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Forecast {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("weekday")
    @Expose
    private String weekday;
    @SerializedName("max")
    @Expose
    private int max;
    @SerializedName("min")
    @Expose
    private int min;
    @SerializedName("cloudiness")
    @Expose
    private float cloudiness;
    @SerializedName("rain")
    @Expose
    private float rain;
    @SerializedName("rain_probability")
    @Expose
    private int rainProbability;
    @SerializedName("wind_speedy")
    @Expose
    private String windSpeedy;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("condition")
    @Expose
    private String condition;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(float cloudiness) {
        this.cloudiness = cloudiness;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public int getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(int rainProbability) {
        this.rainProbability = rainProbability;
    }

    public String getWindSpeedy() {
        return windSpeedy;
    }

    public void setWindSpeedy(String windSpeedy) {
        this.windSpeedy = windSpeedy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
