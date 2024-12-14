package ru.zero_to_one.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import ru.zero_to_one.dto.ResearchWorkerDto;
import ru.zero_to_one.entity.ResearchWorker;
import ru.zero_to_one.mapper.ResearchWorkerMapper;
import ru.zero_to_one.repository.ResearchWorkerRepository;

@RestController
@RequestMapping("/api/research")
@RequiredArgsConstructor
public class ResearchWorkerController {

    private final ResearchWorkerRepository researchWorkerRepository;

    private final ResearchWorkerMapper researchWorkerMapper;

    @GetMapping
    public PagedModel<ResearchWorkerDto> getList(Pageable pageable) {
        Page<ResearchWorker> researchWorkers = researchWorkerRepository.findAll(pageable);
        Page<ResearchWorkerDto> researchWorkerDtoPage = researchWorkers.map(researchWorkerMapper::toDto);
        return new PagedModel<>(researchWorkerDtoPage);
    }

    @GetMapping("/{id}")
    public ResearchWorkerDto getOne(@PathVariable UUID id) {
        Optional<ResearchWorker> researchWorkerOptional = researchWorkerRepository.findById(id);
        return researchWorkerMapper.toDto(researchWorkerOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    @PostMapping
    public ResearchWorkerDto create(@RequestBody ResearchWorkerDto dto) {
        if (!Objects.isNull(dto.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        ResearchWorker researchWorker = researchWorkerMapper.toEntity(dto);
        ResearchWorker resultResearchWorker = researchWorkerRepository.save(researchWorker);
        return researchWorkerMapper.toDto(resultResearchWorker);
    }


    @PutMapping
    public ResearchWorkerDto update(@RequestBody ResearchWorkerDto dto) {
        ResearchWorker researchWorker = researchWorkerRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Нельзя обновить пользователя с таким id"));
        researchWorkerMapper.map(researchWorker, dto);
        ResearchWorker resultResearchWorker = researchWorkerRepository.save(researchWorker);
        return researchWorkerMapper.toDto(resultResearchWorker);
    }

    @DeleteMapping("/{id}")
    public ResearchWorkerDto delete(@PathVariable UUID id) {
        ResearchWorker researchWorker = researchWorkerRepository.findById(id).orElse(null);
        if (researchWorker != null) {
            researchWorkerRepository.delete(researchWorker);
        }
        return researchWorkerMapper.toDto(researchWorker);
    }
}
