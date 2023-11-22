package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;//ID
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
    private Short gender;//性别
    private String image;//图像
    private Short job;//职位
    private LocalDate entrydate;//入职日期——年月日
    private Integer deptId;//部门
    private LocalDateTime createTime;//创建时间——年月日+时分秒
    private LocalDateTime updateTime;//修改时间
}
