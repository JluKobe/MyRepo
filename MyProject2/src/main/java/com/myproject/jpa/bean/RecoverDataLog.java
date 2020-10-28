package com.myproject.jpa.bean;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "recover_data_log")
public class RecoverDataLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    private Long id;

    @Column(name = "operate_type", nullable = true, length = 20)
    private String operateType;

    @Column(name = "log", nullable = false, length = 500)
    private String log;

    @Column(name = "operate_time", nullable = false)
    private Date operateTime;

    @Column(name = "error", nullable = false, length = 10)
    private String error;
}
