package com.bean.entity.igt;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableName(value = "igt_task_material_catalog")
public class IgtTaskMaterial implements Serializable {
    private static final long serialVersionUID = -108907189034815108L;

    @Id
    private String id;

    private String createOrgId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    private String createUserId;

    private String updateOrgId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    private String updateUserId;

    private String version;

    private String areaCode;

    private String acceptStand;

    private String byLaw;

    private String exampleGuid;

    private String fillExplain;

    private String formGuid;

    private String handleType;

    private String isNeed;

    private String isReused;

    private String materialCategory;

    private String materialFormat;

    private String materialGuid;

    private String materialKeyPoint;

    private String materialName;

    private String materialType;

    private String pageFormat;

    private String pageNum;

    private String sourceExplain;

    private String sourceType;

    private String taskGuid;
}
