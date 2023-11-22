package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        empMapper.delete(28);
    }

    @Test
    public void testInsert(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom5");
        emp.setName("汤姆5");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);

        //执行新增员工信息操作
        empMapper.insert(emp);
    }

    @Test
    public void testUpdate(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(16);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行更新操作
        empMapper.update(emp);

    }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(28);
        System.out.println(emp);
    }

    @Test
    public void testList(){
        List<Emp> emplist = empMapper.list("张", (short)1,LocalDate.of(2010,1,1), LocalDate.of(2020,1,1) );
        System.out.println(emplist);
    }

}
