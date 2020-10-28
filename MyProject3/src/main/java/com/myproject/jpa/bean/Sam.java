package com.myproject.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Sam")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    private Long id;

    @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true, length = 20)
    private Date createTime;

    @Column(name = "sam_score", nullable = true, length = 100)
    private String samScore;

    @Column(name = "data", nullable = true, length = 200)
    private String data;

    @Column(name = "error", nullable = true, length = 100)
    private String error;
}
