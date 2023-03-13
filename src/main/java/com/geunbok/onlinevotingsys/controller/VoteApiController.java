package com.geunbok.onlinevotingsys.controller;

import com.geunbok.onlinevotingsys.controller.dto.CandidateResponseDto;
import com.geunbok.onlinevotingsys.controller.dto.VoteDto;
import com.geunbok.onlinevotingsys.domain.Candidate;
import com.geunbok.onlinevotingsys.service.CandidateService;
import com.geunbok.onlinevotingsys.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoteApiController {
    private final CandidateService candidateService;
    private final VoteService voteService;

    @PostMapping("/api/v1/vote")
    public Long vote(@RequestBody VoteDto vote) {
        return voteService.vote(vote);
    }

    @GetMapping("/api/v1/voteresult/{id}")
    public List<Integer> getVoteResult(@PathVariable Long id) {
        candidateService.findById(id);
        List<Integer> data = voteService.getVoteResult();

        return data;
    }
}
