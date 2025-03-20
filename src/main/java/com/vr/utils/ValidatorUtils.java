package com.vr.utils;
//
//
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//
////import com.vr.entity.EIException;
//
///**
// * hibernate-validator校验工具类
// */
//public class ValidatorUtils {
//    private static Validator validator;
//
//    static {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    /**
//     * 校验对象
//     * @param object        待校验对象
//     * @param groups        待校验的组
//     * @throws EIException  校验不通过，则报EIException异常
//     */
////    public static void validateEntity(Object object, Class<?>... groups)
////            throws EIException {
////        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
////        if (!constraintViolations.isEmpty()) {
////        	ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
////            throw new EIException(constraint.getMessage());
////        }
////    }
//
//
//}


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hibernate Validator 校验工具类
 */
public class ValidatorUtils {
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidatorUtils() {
        // 私有构造防止实例化
    }

    /**
     * 校验实体对象（返回所有错误信息）
     * @param object 待校验对象
     * @param groups 校验组
     * @return 错误信息列表
     */
    public static List<String> validate(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);
        return violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }

    /**
     * 校验实体对象（校验失败抛出异常）
     * @param object 待校验对象
     * @param groups 校验组
     * @throws ServiceException 校验失败时抛出包含所有错误的异常
     */
    public static void validateAndThrow(Object object, Class<?>... groups) throws ServiceException {
        List<String> errors = validate(object, groups);
        if (!errors.isEmpty()) {
            throw new ServiceException("数据校验失败: " + String.join(", ", errors));
        }
    }

    // 示例自定义异常
    public static class ServiceException extends RuntimeException {
        public ServiceException(String message) {
            super(message);
        }
    }
}