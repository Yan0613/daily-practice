package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    //新增员工
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    //更新信息
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, " +
            "entrydate  = #{entrydate}, dept_id = #{deptId}, " +
            "update_time = #{updateTime} where id  = #{id}")

    public void update(Emp emp);

    //查询信息
    //手动映射：
//    @Results({
//        @Result(column = "dept_id", property = "deptId"),
//        @Result(column = "create_time", property = "createTime"),
//        @Result(column = "update_time", property = "updateTime")
//    })
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //条件查询
//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc ")
    public List<Emp> list(String name, short gender , LocalDate begin, LocalDate end);

//    //条件查询----拼接
//    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc ")
//    public List<Emp> list(String name, short gender , LocalDate begin, LocalDate end);

    //批量删除
    public void deleteByIds(List<Integer> ids);
}
