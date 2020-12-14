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
@TableName(value = "clean_dn_task_general_extend")
public class CleanExtend {

    private String id;

    private String isentrycenter;

    private String isexpress;

    private String ispayonline;

    private String isonline;

    private String isschedule;

    private String isserviceterminals;

    private String taskguid;

    private String resulttype;

    private String resultname;

    private String handlearea;

    private String limitexplain;

    private String onlinehandledepth;

    private String onlinehandleurl;

    private String otherdept;

    private String taskhandleitem;

    private String limitsceneexplain;

    private String servicetype;
}
