package com.equipment.management;

import com.equipment.management.config.RsaKeyproperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.equipment.management.mapper")
@EnableConfigurationProperties(RsaKeyproperties.class)
public class EquipmentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentManagementSystemApplication.class, args);
    }

}
