package com.myapp.backendactivityfinder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Statistics {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "likeStat")
    private Long likeStat;

    @Column(name = "artStat")
    private Long artStat;

    @Column(name = "eduStat")
    private Long eduStat;

    @Column(name = "motionStat")
    private Long motionStat;

    @Column(name = "carStat")
    private Long carStat;

    @Column(name = "oneStat")
    private Long oneStat;

    @Column(name = "twoStat")
    private Long twoStat;

    @Column(name = "moreStat")
    private Long moreStat;

    @Column(name = "outdoorStat")
    private Long outdoorStat;

    @Column(name = "indoorStat")
    private Long indoorStat;

    @Column(name = "summerStat")
    private Long summerStat;

    @Column(name = "winterStat")
    private Long winterStat;
}
