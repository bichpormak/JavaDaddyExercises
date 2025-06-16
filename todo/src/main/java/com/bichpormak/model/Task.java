package com.bichpormak.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;


@Data
@Builder(toBuilder = true)
public class Task {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private OffsetDateTime startOfTerm;
    @NotNull
    private OffsetDateTime endOfTerm;
    @Builder.Default
    private Status status = Status.CREATED;

    public enum Status {
        CREATED,
        IN_PROGRESS,
        DONE
    }

}
