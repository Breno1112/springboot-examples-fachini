package com.breno.example.api.dtos.data;

import com.breno.example.api.enums.OutputMessageEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponseDTO {



    private OutputMessageEnum outputMessage;

    public OutputMessageEnum getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(OutputMessageEnum outputMessage) {
        this.outputMessage = outputMessage;
    }
}
