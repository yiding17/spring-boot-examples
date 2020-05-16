package com.neo.constant;

/**
 * Created by liuyingan on 20/5/16.
 */
public interface Constant {

    enum Redis implements Constant {
        TOKEN_PREFIX("omy","token前缀"),
        ;
        private String value;
        private String desc;
        Redis(String value,String desc){
            this.value = value;
            this.desc = desc;
        }

        public String getValue(){
            return value;
        }

        public String getDesc(){
            return desc;
        }
    }


    enum ResponseCode implements Constant{
        ILLEGAL_ARGUMENT(1,"非法参数"),
        REPETITIVE_OPERATION(2,"重复提交");
        private int code;
        private String desc;
        ResponseCode(int code,String desc){
            this.code = code;
            this.desc = desc;
        }

        public int getCode(){
            return code;
        }

        public String getDesc(){
            return desc;
        }
    }

    enum FeEnum implements Constant{
        TOKEN_NAME("mytoken","前端header里token参数固定值"),
        ;
        private String value;
        private String desc;
        FeEnum(String value,String desc){
            this.value = value;
            this.desc = desc;
        }

        public String getValue(){
            return value;
        }

        public String getDesc(){
            return desc;
        }
    }
}
