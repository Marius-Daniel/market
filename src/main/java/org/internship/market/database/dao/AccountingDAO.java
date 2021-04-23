package org.internship.market.database.dao;

import org.internship.market.database.entity.AccountingEntity;

public interface AccountingDAO {

    void save(AccountingEntity accountingEntity);

    AccountingEntity getAccountingById(long id);

    void deleteAccountingById(long id);

    void updateCosts(double costs, long id);
}
