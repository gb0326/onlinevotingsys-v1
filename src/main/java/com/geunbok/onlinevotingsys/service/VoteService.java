package com.geunbok.onlinevotingsys.service;

import com.geunbok.onlinevotingsys.controller.dto.VoteDto;
import com.geunbok.onlinevotingsys.domain.CandidateRepository;
import com.geunbok.onlinevotingsys.domain.Vote;
import com.geunbok.onlinevotingsys.domain.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;

    @Transactional
    public Long vote(VoteDto voteDto){
        Vote vote = Vote.builder()
                .candidate(candidateRepository.findById(voteDto.getId()).get())
                .opposite(voteDto.isOpposite())
                .build();

        return voteRepository.save(vote).getId();
    }

    public ArrayList<Integer> getVoteResult() {

        ArrayList<Integer> result = new ArrayList<>();

        long agreeCount = voteRepository.countByVotedId();
        long disagreeCount = voteRepository.countByNotVotedId();

        result.add((int)agreeCount);
        result.add((int)disagreeCount);

        return result;
    }

}
