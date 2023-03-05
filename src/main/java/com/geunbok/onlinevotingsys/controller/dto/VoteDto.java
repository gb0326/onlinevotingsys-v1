package com.geunbok.onlinevotingsys.controller.dto;

import com.geunbok.onlinevotingsys.domain.Vote;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class VoteDto implements Serializable {
    private Long id;
    private boolean opposite;

    public VoteDto(Long id, boolean opposite) {
        this.id = id;
        this.opposite = opposite;
    }
}
