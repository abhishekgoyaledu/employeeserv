package com.paypal.bfs.test.employeeserv.model;

import com.fasterxml.jackson.annotation.*;

public class DateOfBirth {

    @JsonProperty("date")
    @JsonPropertyDescription("Day")
    private Integer date;

    @JsonProperty("month")
    @JsonPropertyDescription("Month")
    private Integer month;

    @JsonProperty("year")
    @JsonPropertyDescription("Year")
    private Integer year;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
