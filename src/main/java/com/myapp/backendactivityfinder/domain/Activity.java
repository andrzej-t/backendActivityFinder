package com.myapp.backendactivityfinder.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "NAME", unique = true)
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    @NotNull
    private String description;

    @Column(name = "MIN_TIME")
    @NotNull
    private Integer minTime;

    @Column(name = "MAX_TIME")
    @NotNull
    private Integer maxTime;

    @Column(name = "ONE")
    @NotNull
    private Boolean onePerson;

    @Column(name = "TWO")
    @NotNull
    private Boolean twoPeople;

    @Column(name = "MORE")
    @NotNull
    private Boolean morePeople;

    @Column(name = "OUTDOOR")
    @NotNull
    private Boolean outdoor;

    @Column(name = "INDOOR")
    @NotNull
    private Boolean indoor;

    @Column(name = "SUMMER")
    @NotNull
    private Boolean summer;

    @Column(name = "WINTER")
    @NotNull
    private Boolean winter;

    @Column(name = "IN_CAR")
    @NotNull
    private Boolean inCar;

    @Column(name = "EDUCATIONAL")
    @NotNull
    private Boolean educational;

    @Column(name = "ART")
    @NotNull
    private Boolean art;

    @Column(name = "MOTION")
    @NotNull
    private Boolean motion;

    @Column(name = "FAVOURITE")
    @NotNull
    private Boolean favourite;
}
