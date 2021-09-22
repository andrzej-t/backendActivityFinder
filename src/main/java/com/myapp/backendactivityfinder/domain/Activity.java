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
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "min_time")
    @NotNull
    private Integer minTime;

    @Column(name = "max_time")
    @NotNull
    private Integer maxTime;

    @Column(name = "one")
    @NotNull
    private Boolean onePerson;

    @Column(name = "two")
    @NotNull
    private Boolean twoPeople;

    @Column(name = "more")
    @NotNull
    private Boolean morePeople;

    @Column(name = "outdoor")
    @NotNull
    private Boolean outdoor;

    @Column(name = "indoor")
    @NotNull
    private Boolean indoor;

    @Column(name = "summer")
    @NotNull
    private Boolean summer;

    @Column(name = "winter")
    @NotNull
    private Boolean winter;

    @Column(name = "in_car")
    @NotNull
    private Boolean inCar;

    @Column(name = "educational")
    @NotNull
    private Boolean educational;

    @Column(name = "art")
    @NotNull
    private Boolean art;

    @Column(name = "motion")
    @NotNull
    private Boolean motion;

    @Column(name = "favourite")
    @NotNull
    private Boolean favourite;
}
