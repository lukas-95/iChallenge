package com.iChallenge.notify;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotifyCheckService {

    private final NotifyCheckHistoryRepository notifyCheckHistoryRepository;
    public boolean isApprovedPerson(Long personId) {

        notifyCheckHistoryRepository.save(
                NotifyCheckHistory.builder()
                        .personId(personId)
                        .isApproved(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return true;
    }
}
