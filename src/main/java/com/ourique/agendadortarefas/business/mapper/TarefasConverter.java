package com.ourique.agendadortarefas.business.mapper;


import com.ourique.agendadortarefas.business.dto.TarefasDTO;
import com.ourique.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
