package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location required")
    private String location;

    @OneToMany
    @JoinColumn
    private List<Job> jobs;

    public Employer() {
    }

    public Employer(@NotBlank(message = "Location required") String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
