package com.iChallenge.notify;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifyCheck")
@AllArgsConstructor
@Slf4j
public class NotifyController {

    private final NotifyCheckService notifyCheckService;
    private final NotifyCheckHistoryRepository notifyCheckHistoryRepository;

    @GetMapping(path = "{personId}")
    public NotifyCheckResponse isApproved(@PathVariable ("personId") Long personId) {

        boolean isApproved = notifyCheckService.
                isApprovedPerson(personId);
        log.info("notificacao para pessoa com ID {}", personId);
        return new NotifyCheckResponse(isApproved);
    }

    @PostMapping(path = "{personId}/disapprove")
    public ResponseEntity<Void> disapprovePerson(@PathVariable("personId") Long personId) {
        notifyCheckService.disapprovePerson(personId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/history")
    public List<NotifyCheckHistory> getAllNotifyCheckHistory() {
        return notifyCheckHistoryRepository.findAll();
    }

    @GetMapping("/history/{id}")
    public NotifyCheckHistory getNotifyCheckHistoryById(@PathVariable("id") Long id) {
        return notifyCheckHistoryRepository.findById(id).orElse(null);
    }

}
