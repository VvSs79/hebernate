package DTO;

import java.time.LocalDateTime;

public class InformationTop {
    private LocalDateTime ldInit;
    private String information;

    public InformationTop(LocalDateTime ldInit, String information) {
        this.ldInit = ldInit;
        this.information = information;
    }

    public LocalDateTime getLdInit() {
        return ldInit;
    }

    public String getInformation() {
        return information;
    }
}
