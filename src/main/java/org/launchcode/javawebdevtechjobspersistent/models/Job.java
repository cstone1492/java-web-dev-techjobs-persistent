package org.launchcode.javawebdevtechjobspersistent.models;

import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    private Employer employer;

    @ManyToMany
    private final List<Skill> skills = new ArrayList<>();


    public Job() {
    }

    public Job(Employer anEmployer, SkillRepository someSkills) {
        super();
        this.employer = anEmployer;
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

}
