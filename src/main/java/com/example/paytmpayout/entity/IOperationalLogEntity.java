package com.example.paytmpayout.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author BINGAI
 * @since 2021-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("operational_log")
public class IOperationalLogEntity extends Model<IOperationalLogEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 注册的token
     */
    @TableField("registration_token")
    private String registrationToken;

    /**
     * 操作内容
     */
    @TableField("operational_content")
    private String operationalContent;

    /**
     * 操作耗时 (milliseconds)
     */
    @TableField("time_consuming")
    private Long timeConsuming;

    /**
     * 操作方法
     */
    @TableField("operational_method")
    private String operationalMethod;

    /**
     * 操作参数
     */
    @TableField("operational_params")
    private String operationalParams;

    /**
     * 操作者IP
     */
    @TableField("operational_ip")
    private String operationalIp;

    /**
     * 响应参数
     */
    @TableField("response_parameters")
    private String responseParameters;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime ;

    /**
     * 创建时间戳
     */
    @TableField("create_timestamp")
    private Long createTimestamp;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
