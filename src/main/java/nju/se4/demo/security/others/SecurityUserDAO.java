package nju.se4.demo.security.others;



import nju.se4.demo.security.SecurityUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SecurityUserDAO extends CrudRepository<SecurityUser, String>, JpaSpecificationExecutor<SecurityUser>, ExtraSecurityUser {
    SecurityUser findBySecurityUserName(String SecurityUserName);
}
