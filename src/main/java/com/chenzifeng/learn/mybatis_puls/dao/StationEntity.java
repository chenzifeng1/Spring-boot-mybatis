package com.chenzifeng.learn.mybatis_puls.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @program: com.chenzifeng.learn.mybatis_puls
 * @author: chenzifeng
 * @description:
 * @create: 2020-06-03 19:43
 **/
@Data
@TableName("test_station")
public class StationEntity {

    @TableId
    private int id;

    @TableField(exist = false)
    private List<String> tankCodes;

    @TableField("STATION_NAME")
    private String name;

    private int stationCode;
    private int orgId;
    private String orgName;
    private int orgCode;

}
