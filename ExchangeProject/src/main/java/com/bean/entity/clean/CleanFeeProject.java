package com.bean.entity.clean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableName(value = "clean_dn_task_general_fee_project")
public class CleanFeeProject {

    @Column(name = "id")
    private String id;

    @Column(name = "feestand")
    private String feestand;

    @Column(name = "feename")
    private String feename;

    @Column(name = "isdesc")
    private String isdesc;

    @Column(name = "descexplain")
    private String descexplain;

    @Column(name = "taskguid")
    private String taskguid;
}
