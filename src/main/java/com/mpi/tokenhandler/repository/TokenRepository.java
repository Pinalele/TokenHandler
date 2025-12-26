package com.mpi.tokenhandler.repository;

import com.mpi.tokenhandler.model.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {


}
