package org.jaganyv.basic_crud.repository;

import org.jaganyv.basic_crud.entity.Crud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepo extends JpaRepository<Crud,Integer> {
}
