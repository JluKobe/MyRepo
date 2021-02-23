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
@TableName(value = "clean_dn_task_public_fee_project")
public class CleanPublicFeeProject {

    private String id;

    private String feestand;

    private String feename;

    private String isdesc;

    private String descexplain;

    private String taskguid;

    private String taskhandleitem;

    private String bylaw;

    private String remark;

    private String taskcode;
}
