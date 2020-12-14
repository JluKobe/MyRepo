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
@TableName(value = "clean_dn_task_general_fee_project")
public class CleanFeeProject {

    private String id;

    private String feestand;

    private String feename;

    private String isdesc;

    private String descexplain;

    private String taskguid;
}
