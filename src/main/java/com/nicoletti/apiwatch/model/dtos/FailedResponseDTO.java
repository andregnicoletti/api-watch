package com.nicoletti.apiwatch.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FailedResponseDTO extends ResponseDTO {

    private String message;

    public FailedResponseDTO(String message) {
        super(false);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
