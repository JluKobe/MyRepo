package com.bean.entity.clean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableName(value = "clean_dn_task_general_questions")
public class CleanQuestions {
    private String id;

    private String taskcode;

    private String taskguid;

    private String ordernum;

    private String question;

    private String answer;

    private String taskhandleitem;
}
