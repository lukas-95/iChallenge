package com.iChallenge.notify;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@AllArgsConstructor
public class NotifyCheckService {

    private final NotifyCheckHistoryRepository notifyCheckHistoryRepository;
    private final Map<Long, Boolean> approvalStatusMap = new ConcurrentHashMap<>();

    public boolean isApprovedPerson(Long personId) {

        Boolean approvalStatus = approvalStatusMap.get(personId);
        if (approvalStatus != null) {
            return approvalStatus;
        }


        approvalStatus = true; //todo Aplicar lógica para determinar se vai ser aprovado ou não


        approvalStatusMap.put(personId, approvalStatus);


        notifyCheckHistoryRepository.save(
                NotifyCheckHistory.builder()
                        .personId(personId)
                        .isApproved(approvalStatus)
                        .createdAt(LocalDateTime.now())
                        .build()
        );



        return approvalStatus;
    }
}
