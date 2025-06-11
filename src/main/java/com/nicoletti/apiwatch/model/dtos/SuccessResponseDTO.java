package com.nicoletti.apiwatch.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponseDTO extends ResponseDTO {

    public SuccessResponseDTO() {
        super(true);
    }

}
