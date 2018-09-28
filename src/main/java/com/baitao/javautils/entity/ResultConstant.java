package com.baitao.javautils.entity;


/**
 * 定义成interface 就默认是 public static final
 * @author baitao
 * @date 2018/9/28 11:26
 */
public interface ResultConstant {

    /**
     *common result
     */
	int OP_SUCC = 0;

	int OP_FAIL = -1;


    int OBJECT_NOT_EXIST = 404;
    int SYNTAX_ERROR = 405;

    int INCORRECT_PARAM_VALUE = 406;
    int INCORRECT_PARAM_NO = 407;
    int NOT_SUPPORTED = 408;

    int PERMISSION_DENIED = 2001;

    int INCORRECT_ACCESSTOKEN= 2002;

    int ILLEGAL_STATE = 2100;

}
