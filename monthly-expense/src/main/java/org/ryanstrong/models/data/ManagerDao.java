package org.ryanstrong.models.data;


import org.ryanstrong.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ManagerDao extends CrudRepository<Manager, Integer>{
}
