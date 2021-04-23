package org.internship.market.services;

import org.internship.market.dto.AccountingDTO;

public interface AccountingServices {

    void insert(AccountingDTO accountingDTO);

    AccountingDTO getAccountingById(long id);

    void deleteAccountingById(long id);

    void updateCosts(double costs, long id);
}
