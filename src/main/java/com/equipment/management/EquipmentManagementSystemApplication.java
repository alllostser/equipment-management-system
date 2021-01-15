package com.equipment.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.equipment.management.mapper")
public class EquipmentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentManagementSystemApplication.class, args);
    }

}
