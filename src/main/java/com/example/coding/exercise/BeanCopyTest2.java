package com.example.coding.exercise;;

import lombok.Data;

import java.util.List;

/**
 * @author liqingtai
 * @date 2020-09-15
 */
@Data
public class BeanCopyTest2 {
    private String outerName;
    private BeanCopyTest2.InnerClass innerClass;
    private List<BeanCopyTest2.InnerClass> innerClassList;

    @Data
    public static class InnerClass {
        private String innerName;

        public InnerClass() {

        }

        public InnerClass(String innerName) {
            this.innerName = innerName;
        }
    }
}
