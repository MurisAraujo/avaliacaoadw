/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.murilo.tads.avaliacao.repository;

import br.murilo.tads.avaliacao.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Beto
 */
public interface ProdutoRepository extends CrudRepository<User ,String>{
    User findById(long id);
}
