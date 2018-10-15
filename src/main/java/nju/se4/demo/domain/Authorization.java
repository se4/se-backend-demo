package nju.se4.demo.domain;

import javax.persistence.*;

@Entity
public class Authorization {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 用户
     */
    @OneToOne
    private User user;

    /**
     * 服务器的token
     */
    private String token;



}
