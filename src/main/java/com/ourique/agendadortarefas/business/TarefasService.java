package com.ourique.agendadortarefas.business;

import com.ourique.agendadortarefas.business.dto.TarefasDTO;
import com.ourique.agendadortarefas.business.mapper.TarefasConverter;
import com.ourique.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.ourique.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.ourique.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.ourique.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
