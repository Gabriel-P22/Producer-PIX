package com.alura.pix.usecase;

import com.alura.pix.entrypoints.dto.PixDto;
import com.alura.pix.infrastructure.database.adapters.LocalDateTimeAdapter;
import com.alura.pix.infrastructure.database.model.Pix;
import com.alura.pix.infrastructure.database.repository.PixRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PixUseCase {

  @Autowired private final PixRepository repository;

  @Autowired private final KafkaTemplate<String, String> kafkaTemplate;

  public PixDto savePix(PixDto pixDto) {

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    repository.save(Pix.toEntity(pixDto));

    String message = gson.toJson(pixDto);

    kafkaTemplate.send("pix-topic", message);

    return pixDto;
  }
}
