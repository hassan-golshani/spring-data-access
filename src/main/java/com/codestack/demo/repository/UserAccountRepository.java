package com.codestack.demo.repository;

import com.codestack.demo.model.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserAccount save(UserAccount userAccount) {
        entityManager.persist(userAccount);
        return userAccount;
    }

    public List<UserAccount> findAll() {
        return entityManager.createQuery("select u from UserAccount u").getResultList();
    }
}