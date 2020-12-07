package mybatis.vo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 事项材料目录信息表
 */

@Entity
@Data
@Table(name = "igt_task_material_catalog")
@org.hibernate.annotations.Table(appliesTo = "igt_task_material_catalog", comment = "事项材料目录信息表")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IgtTaskMaterialCatalog {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '雪花算法生成的ID'", nullable = false)
    private Long id;

    @Column(name = "version", columnDefinition = "int(10) comment '版本号' default 1", nullable = false)
    private Integer version;

//    @Column(name = "create_time", columnDefinition = "datetime comment '创建时间'", nullable = false)
//    private LocalDateTime createTime;

    @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
    private Long createUserId;

    @Column(name = "create_org_id", columnDefinition = "bigint(20) comment '创建机构ID'", nullable = false)
    private Long createOrgId;

//    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'", nullable = false)
//    private LocalDateTime updateTime;

    @Column(name = "update_user_id", columnDefinition = "bigint(20) comment '更新人ID'", nullable = false)
    private Long updateUserId;

    @Column(name = "update_org_id", columnDefinition = "bigint(20) comment '更新机构ID'", nullable = false)
    private Long updateOrgId;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'")
    private String taskGuid;

    @Column(name = "material_guid", columnDefinition = "varchar(50) comment '材料唯一标识'")
    private String materialGuid;

    @Column(name = "material_category", columnDefinition = "varchar(256) comment '办件材料类别'")
    private String materialCategory;

    @Column(name = "material_name", columnDefinition = "varchar(200) comment '材料名称'")
    private String materialName;

    @Column(name = "page_num", columnDefinition = "int(11) comment '纸质材料分数'")
    private String pageNum;

    @Column(name = "page_format", columnDefinition = "varchar(200) comment '纸质材料规格'")
    private String pageFormat;

    @Column(name = "material_type", columnDefinition = "varchar(2) comment '材料类型'")
    private String materialType;

    @Column(name = "material_format", columnDefinition = "varchar(2) comment '材料形式'")
    private String materialFormat;

    @Column(name = "material_key_point", columnDefinition = "varchar(512) comment '审查要点'")
    private String materialKeyPoint;

    @Column(name = "handle_type", columnDefinition = "varchar(5) comment '办理形式'")
    private String handleType;

    @Column(name = "form_guid", columnDefinition = "varchar(256) comment '空白范本'")
    private String formGuid;

    @Column(name = "example_guid", columnDefinition = "varchar(256) comment '示例范本'")
    private String exampleGuid;

    @Column(name = "is_need", columnDefinition = "varchar(2) comment '材料必要性'")
    private String isNeed;

    @Column(name = "is_reused", columnDefinition = "varchar(10) comment '是否可复用'")
    private String isReused;

    @Column(name = "source_type", columnDefinition = "varchar(2) comment '来源渠道'")
    private String sourceType;

    @Column(name = "source_explain", columnDefinition = "varchar(500) comment '来源渠道说明'")
    private String sourceExplain;

    @Column(name = "fill_explain", columnDefinition = "varchar(500) comment '填报须知'")
    private String fillExplain;

    @Column(name = "by_law", columnDefinition = "varchar(256) comment '要求材料提供的依据'")
    private String byLaw;

    @Column(name = "accept_stand", columnDefinition = "varchar(256) comment '受理标准'")
    private String acceptStand;
}
