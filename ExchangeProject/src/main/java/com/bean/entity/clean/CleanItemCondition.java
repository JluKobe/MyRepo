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
@TableName(value = "clean_dn_audit_item_condition")
public class CleanItemCondition {

    private String id;

    private String rowguid;

    private String taskguid;

    private String conditionName;

    private String conditionDesc;

    private String taskhandleitem;
}
