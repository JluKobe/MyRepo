package com.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = true, length = 100)
    private String word;

    @Column(name = "meaning", nullable = true, length = 100)
    private String meaning;

    @Column(name = "sentence", nullable = true, length = 300)
    private String sentence;

    @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true, length = 20)
    private Date createTime;
}
