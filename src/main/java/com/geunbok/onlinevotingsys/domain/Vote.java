package com.geunbok.onlinevotingsys.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Vote extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Candidate candidate;

    @Column
    private boolean opposite;

    @Builder
    public Vote(Candidate candidate, boolean opposite){
        this.candidate = candidate;
        this.opposite = opposite;
    }
}
