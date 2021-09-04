package com.myapp.backendactivityfinder.domain;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MIN_TIME")
    private Integer minTime;

    @Column(name = "MAX_TIME")
    private Integer maxTime;

    @Column(name = "ONE")
    private Boolean onePerson;

    @Column(name = "TWO")
    private Boolean twoPeople;

    @Column(name = "MORE")
    private Boolean morePeople;

    @Column(name = "OUTDOOR")
    private Boolean outdoor;

    @Column(name = "INDOOR")
    private Boolean indoor;

    @Column(name = "SUMMER")
    private Boolean summer;

    @Column(name = "WINTER")
    private Boolean winter;

    @Column(name = "IN_CAR")
    private Boolean inCar;

    @Column(name = "EDUCATIONAL")
    private Boolean educational;

    @Column(name = "ART")
    private Boolean art;

    @Column(name = "MOTION")
    private Boolean motion;

    @Column(name = "FAVOURITE")
    private Boolean favourite;
}
