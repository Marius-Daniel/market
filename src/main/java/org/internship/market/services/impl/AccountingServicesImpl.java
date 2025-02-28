package org.internship.market.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.internship.market.services.mapper.AccountingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountingServicesImpl implements AccountingServices {


    @Autowired
    AccountingDAO accountingDAO;

    @Autowired
    AccountingMapper mapper;

    @Override

    public void insert(AccountingDTO accountingDTO) {
        AccountingEntity accountingEntity = mapper.dtoToEntity(accountingDTO);
        log.info("insert : {} ", accountingEntity.toString());
        accountingDAO.save(accountingEntity);
    }

    @Override

    public List<AccountingDTO> getAllAccounting() {
        List<AccountingEntity> allEntities = accountingDAO.getAll();
        log.info("getAllAccounting size : {} ", allEntities.size());
        return mapper.entitiesToDtoS(allEntities);
    }

    @Override

    public void deleteAccounting() {
        log.info("Service delete");
        accountingDAO.deleteAccounting();
    }

    @Override

    public void updateCosts(double costs) {
        log.info("Service update cost for  cost : {} ", costs);
        accountingDAO.updateCosts(costs);
    }

    @Override

    public void updateIncome(double income) {
        log.info("Service update income for  income : {} ", income);
        accountingDAO.updateIncome(income);
    }

}
