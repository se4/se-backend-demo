package nju.se4.demo.security;

import lombok.Data;
import nju.se4.demo.dao.UserDAO;
import nju.se4.demo.domain.User;
import nju.se4.demo.enumeration.UserIdentity;
import nju.se4.demo.security.exception.InvalidOperationException;
import nju.se4.demo.security.exception.NotFoundException;
import nju.se4.demo.security.others.SecurityUserDAO;
import nju.se4.demo.util.Response;
import nju.se4.demo.util.innerData.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Service
@RestController
public class UserDetailsServiceImp implements UserDetailsService {
    private final SecurityProperties securityProperties;
    private final String NOOP = "{noop}";

    @Autowired
    private SecurityUserDAO securityUserDAO;

    private UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImp(SecurityProperties securityProperties, UserDAO userDAO) {
        this.securityProperties = securityProperties;
        this.userDAO = userDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        SecurityUser securityUser = securityUserDAO.findByUsername(username);

        if (securityUser == null) {
            throw new NotFoundException(username);
        }
        return securityUser;
    }

    /**
     * 注册的时候会在密码前加noop
     */
    @RequestMapping(value = "/api/v1/authorization/register", method = RequestMethod.POST)
    public Response<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(NOOP + userDTO.getPassword());

        SecurityUser oriUser = securityUserDAO.findByUsername(userDTO.getUsername());
        if (oriUser != null) {
            throw new InvalidOperationException("此用户已被注册");
        }


        User newUser=new User();
        newUser.setNickName(userDTO.getNickname());
        newUser.setPassword(userDTO.getPassword());
        newUser.setUsername(userDTO.getUsername());
        newUser.setUserIdentity(UserIdentity.STUDENT);
        userDAO.save(newUser);

        SecurityUser securityUser = new SecurityUser(newUser);
        securityUserDAO.save(securityUser);

        Abilities abilities = new Abilities();
        abilities.setUpdate(true);
        return new Response<UserDTO>(abilities,userDTO);

    }

//    /**
//     * 修改密码要在密码前加{noop}
//     */
//    @RequestMapping("/user/password/{user_name}")
//    public boolean changePassword(@PathVariable(value = "user_name") String username, @RequestBody PasswordVO passwordVO) {
//        return securityUserDAO.updatePassword(username, NOOP + passwordVO.getOriPassword(),
//                NOOP + passwordVO.getNewPassword());
//    }


}
@Data
//@AllArgsConstructor
class UserDTO{
    @Pattern(regexp = "[0-9a-zA-Z_]{4,16}", message = "用户名只能包含大小写字母、数字和下划线，且必须为4-16位！", groups = PostMapping.class)
    @NotNull(message = "请填写用户名！", groups = PostMapping.class)
    String username;
    @NotNull(message = "请填写密码！", groups = PostMapping.class)
    String password;
    String nickname;
}