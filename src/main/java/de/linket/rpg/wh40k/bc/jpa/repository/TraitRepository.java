package de.linket.rpg.wh40k.bc.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.linket.rpg.wh40k.bc.jpa.domain.TraitBE;

/**
 * For Spring Data JPA query methods see:
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
public interface TraitRepository extends JpaRepository<TraitBE, Long>
{

    public TraitBE findByName(String name);

}