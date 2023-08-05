package com.iChallenge.notify;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifyCheck")
@AllArgsConstructor
@Slf4j
public class NotifyController {

    private final NotifyCheckService notifyCheckService;

    @GetMapping(path = "{personId}")
    public NotifyCheckResponse isApproved(@PathVariable ("personId") Long personId) {

        boolean isApproved = notifyCheckService.
                isApprovedPerson(personId);

        return new NotifyCheckResponse(isApproved);
    }

}
