package com.ourique.agendadortarefas.infrastructure.repository;

import com.ourique.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository  extends MongoRepository<TarefasEntity, String> {
}
