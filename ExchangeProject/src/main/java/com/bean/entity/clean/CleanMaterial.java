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
@TableName(value = "clean_dn_task_general_material")
public class CleanMaterial {

    private String id;

    private String taskguid;

    private String rowguid;

    private String materialname;

    private String pagenum;

    private String pageformat;

    private String materialtype;

    private String materialformat;

    private String formguid;

    private String exampleguid;

    private String isneed;

    private String sourcetype;

    private String sourceexplain;

    private String fillexplain;

    private String bylaw;

    private String acceptstand;

    private String taskhandleitem;
}
