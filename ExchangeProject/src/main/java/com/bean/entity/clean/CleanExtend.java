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
@TableName(value = "clean_dn_task_general_extend")
public class CleanExtend {

    @Column(name = "id")
    private String id;

    @Column(name = "isentrycenter")
    private String isentrycenter;

    @Column(name = "isexpress")
    private String isexpress;

    @Column(name = "ispayonline")
    private String ispayonline;

    @Column(name = "isonline")
    private String isonline;

    @Column(name = "isschedule")
    private String isschedule;

    @Column(name = "isserviceterminals")
    private String isserviceterminals;

    @Column(name = "taskguid")
    private String taskguid;

    @Column(name = "resulttype")
    private String resulttype;

    @Column(name = "resultname")
    private String resultname;

    @Column(name = "handlearea")
    private String handlearea;

    @Column(name = "limitexplain")
    private String limitexplain;

    @Column(name = "onlinehandledepth")
    private String onlinehandledepth;

    @Column(name = "onlinehandleurl")
    private String onlinehandleurl;

    @Column(name = "otherdept")
    private String otherdept;
}
