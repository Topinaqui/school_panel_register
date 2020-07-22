package com.faiton.school_panel_register.repositories;

import java.util.List;

import com.faiton.school_panel_register.entities.ConfirmationToken;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

  List<ConfirmationToken> findByConfirmationToken(String confirmationToken);

}
