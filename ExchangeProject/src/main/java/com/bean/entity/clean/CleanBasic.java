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
@TableName(value = "clean_dn_task_general_basic")
public class CleanBasic {

    private String id;

    private String catalogcode;

    private String deptcode;

    private String deptname;

    private String depttype;

    private String handletype;

    private String linkway;

    private String localcatalogcode;

    private String localtaskcode;

    private String powersource;

    private String projecttype;

    private String promiseday;

    private String servertype;

    private String taskcode;

    private String taskhandleitem;

    private String taskname;

    private String taskstate;

    private String tasktype;

    private String taskversion;

    private String transactaddr;

    private String transacttime;

    private String uselevel;

    private String rowguid;
}
