package net.kiel.domain

import lombok.extern.slf4j.Slf4j
import net.kiel.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

/**
 * Created by kiel on 2016. 4. 19..
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class )
@Transactional
@Slf4j
class RepositoryTest extends Specification {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BugStatusRepository bugStatusRepository;
    @Autowired
    BugRepository bugRepository;

    def "Product-Account 다대다 저장이 가능해야 한다"() {
        given:
        Product product = new Product();
        product.productName = "test product";
        Account account1 = new Account("account1");
        Account account2 = new Account("account2");

        when:
        product.accounts = new ArrayList<>();
        product.accounts << account1
        product.accounts << account2
        productRepository.save(product);

        then:
        productRepository.count() == 1L;
        accountRepository.count() == 2L;
        productRepository.findOne(product.id).accounts.size() == 2;
    }

    def "createdDate는 자동으로 생성되어야 한다"() {
        given:
        Account account = new Account();
        account.name = "account1";
        accountRepository.save(account);
        BugStatus bugStatus = new BugStatus("open");
        bugStatusRepository.save(bugStatus);
        Bug bug = new Bug();
        bug.reporter = account;
        bug.status = bugStatus;

        when:
        def savedBug = bugRepository.save(bug);

        then:
        savedBug.createdDatetime != null;
        savedBug.createdDatetime == savedBug.modifiedDatetime
        println savedBug
        println savedBug.createdDatetime
//        def zonedDatetime = ZonedDateTime.of(savedBug.createdDate, ZoneId.systemDefault())
//        println zonedDatetime
        println savedBug.createdDatetime.getOffset()
    }
}