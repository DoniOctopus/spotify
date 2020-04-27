package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Account;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.AccountRepository;
import com.enigma.excercise.spotify.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AccountServiceDBImplTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @BeforeEach
    public void cleanUp(){
        accountRepository.deleteAll();
    }

    @Test
    void saveAccount_shouldAdd_1Data_inDB_whenAccountSaved() {
        Account account = new Account(Boolean.TRUE);
        accountService.saveAccount(account);
        assertEquals(1,accountRepository.findAll().size());
    }

    @Test
    void getAccount_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            accountService.getAccount("1");
        });
    }

    @Test
    void deleteAccount_shouldDelete_1Data_inDB_whenAccountDeleted() {
        Account account = new Account(Boolean.TRUE);
        Account account1 = new Account(Boolean.TRUE);
        accountRepository.save(account);
        accountRepository.save(account1);
        accountService.deletAccount(account1.getId());
        assertEquals(1,accountRepository.findAll().size());
    }

    @Test
    void getAllAccount_shouldBe_2InDB_whenDataInDBIs_2() {
        Account account = new Account(Boolean.TRUE);
        Account account1 = new Account(Boolean.TRUE);
        accountRepository.save(account);
        accountRepository.save(account1);
        assertEquals(2, accountService.getAllAccount().size());
    }


}