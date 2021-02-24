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
@TableName(value = "clean_dn_task_public_questions")
public class CleanPublicQuestions {
    private String id;

    private String taskguid;

    private String taskcode;

    private String taskhandleitem;

    private String answer;

    private String ordernum;

    private String question;
}
