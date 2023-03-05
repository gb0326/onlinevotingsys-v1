package com.geunbok.onlinevotingsys.controller;

import com.geunbok.onlinevotingsys.controller.dto.VoteDto;
import com.geunbok.onlinevotingsys.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoteApiController {
    private final VoteService voteService;

    @PostMapping("/api/v1/vote")
    public Long vote(@RequestBody VoteDto vote) {
        return voteService.vote(vote);
    }

    /*@GetMapping("/api/v1/vote/{id}")
    public List<Integer> getVoteResult(@PathVariable Long id) {
        List<Integer> data = voteService.getVoteResult(id);

        return data;
    }*/


}
