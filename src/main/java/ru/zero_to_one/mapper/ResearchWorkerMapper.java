package ru.zero_to_one.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.zero_to_one.dto.ResearchWorkerDto;
import ru.zero_to_one.entity.ResearchWorker;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface ResearchWorkerMapper {

    ResearchWorker toEntity(ResearchWorkerDto researchWorkerDto);

    ResearchWorkerDto toDto(ResearchWorker researchWorker);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ResearchWorker partialUpdate(ResearchWorkerDto researchWorkerDto, @MappingTarget ResearchWorker researchWorker);

    ResearchWorker updateWithNull(ResearchWorkerDto researchWorkerDto, @MappingTarget ResearchWorker researchWorker);

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "id", ignore = true)
    void map(@MappingTarget ResearchWorker researchWorker, ResearchWorkerDto dto);
}