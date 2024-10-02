package com.alura.pix.usecase;

import com.alura.pix.entrypoints.dto.PixDto;
import com.alura.pix.infrastructure.database.model.Pix;
import com.alura.pix.infrastructure.database.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixUseCase {

  @Autowired private final PixRepository repository;

  @Autowired private final KafkaTemplate<String, PixDto> kafkaTemplate;

  public PixDto savePix(PixDto pixDto) {
    repository.save(Pix.toEntity(pixDto));

    kafkaTemplate.send("pix-topic", pixDto.getIdentifier(), pixDto);


    return pixDto;
  }
}
