package com.tcc.aluno.Repositories;

import com.tcc.aluno.database.AluAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/*======================================================================================================================
||Interface responsavel por implementar as Query's nativas para obtenção, atualização e remoção de dados. Referente   ||
||ao modulo de alunos e a entidade AluAtividade.                                                                      ||
======================================================================================================================*/
@Repository
public interface AluAtividadeRepository extends JpaRepository<AluAtividade, Long>{
    @Transactional
    @Modifying
    @Query("UPDATE AluAtividade a SET a.url =:url, a.entrega=true WHERE a.alunofk.id = :idalu AND a.atividadefk.id = :ida")
    void atualizaAtividade(@Param("url") String url, @Param("idalu")Long idalu, @Param("ida")Long ida);

    @Query("SELECT a FROM AluAtividade a WHERE a.alunofk.id = :ida AND a.disciplinafk.codigo = :id")
    List<AluAtividade> getAtividadeByDisAlu(@Param("ida") Long ida, @Param("id") Long id);

    @Query("SELECT sum(a.nota) FROM AluAtividade a WHERE a.disciplinafk.codigo = :codigo AND a.alunofk.id = :id AND a.nota>-1")
    Double getSumNotasByAluDis(@Param("codigo")Long codigo, @Param("id") Long id);
}
