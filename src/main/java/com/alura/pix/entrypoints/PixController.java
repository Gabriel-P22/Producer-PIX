package com.alura.pix.entrypoints;

import com.alura.pix.entrypoints.dto.PixDto;
import com.alura.pix.enums.PixStatus;
import com.alura.pix.usecase.PixUseCase;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
@RequiredArgsConstructor
public class PixController {

  @Autowired private final PixUseCase useCase;

  @PostMapping
  public PixDto savePix(@RequestBody PixDto pixDto) {
    pixDto.setIdentifier(UUID.randomUUID().toString());
    pixDto.setTransferDate(LocalDateTime.now());
    pixDto.setStatus(PixStatus.PROCESSING);
    return useCase.savePix(pixDto);
  }
}
