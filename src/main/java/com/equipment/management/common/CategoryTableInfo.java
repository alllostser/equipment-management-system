package com.equipment.management.common;

import lombok.Data;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/03/03 10:28
 */
@Data
public class CategoryTableInfo<T> {
        private Status status;
        /**
         * 列表数据
         */
        private T data;


        public CategoryTableInfo() {
        }
        public CategoryTableInfo( Status status) {
            this.status=status;
        }
        public CategoryTableInfo(Status status , T data) {
            this.status = status;
            this.data=data;
        }
        /**
         * 当接口调用成功
         */
        public static   <T> com.equipment.management.common.CategoryTableInfo ResponseBySucess(Status status, T data){
            return new com.equipment.management.common.CategoryTableInfo(status,data);
        }
        /**
         * 接口调用失败
         */
        public static com.equipment.management.common.CategoryTableInfo ResponseByFail(Status status){
            return new com.equipment.management.common.CategoryTableInfo(status);
        }


}
