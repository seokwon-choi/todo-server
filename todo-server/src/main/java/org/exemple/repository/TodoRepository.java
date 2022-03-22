package org.exemple.repository;

import org.exemple.mobel.TodoMobel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoMobel, Long> {

}
