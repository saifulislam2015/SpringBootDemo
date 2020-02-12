package com.example.Repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImp implements IUserRepositoryCustom {

    @PersistenceContext
    private EntityManager _entityManager;

    @Override
    public boolean doesExist(String email,String pass) {
        Query query = _entityManager.createNativeQuery("select userId from NavigatorDB.dbo.UserInfo where" +
                " email= '"+ email+"' and password='"+pass+"'");
        if(query.getResultList().isEmpty())  return false;
        return true;
    }
}
/*
http://192.168.106.205/CoreServices/HierarchyManager.asmx?WSDL
 */