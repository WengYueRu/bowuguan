///**
// * 【辅助类】
// * 2、全局异常处理器
// *
// * 统一处理应用程序中抛出的异常，返回友好的错误响应
// */
//package com.vr.handler;
//
//import com.vr.utils.R;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.sql.SQLException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // =============================================
//    // 日志配置
//    // =============================================
//
//    /**
//     * 日志记录器
//     * 使用 SLF4J 接口绑定具体的日志实现（如 Logback）
//     * 通过 LoggerFactory 获取当前类的日志实例
//     */
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//
//    // =============================================
//    // 异常处理方法
//    // =============================================
//
//    /**
//     * 处理数据库异常（如 SQL 执行失败）
//     *
//     * @param ex 捕获到的 SQLException
//     * @return 包含错误信息的 R 对象
//     */
//    @ExceptionHandler(SQLException.class)
//    public R handleSQLException(SQLException ex) {
//        // 记录详细的错误日志，包含堆栈跟踪
//        logger.error("数据库操作失败", ex);
//
//        // 返回通用错误信息，避免泄露敏感数据
//        return R.error("系统繁忙，请稍后重试");
//    }
//
//
//    /**
//     * 处理数据校验异常（如 @Valid 注解验证失败）
//     *
//     * @param ex 捕获到的 MethodArgumentNotValidException
//     * @return 包含具体错误信息的 R 对象
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public R handleValidationException(MethodArgumentNotValidException ex) {
//        // 提取第一个校验失败的错误信息
//        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
//
//        // 记录校验失败日志（可选）
//        logger.warn("数据校验失败: {}", message);
//
//        // 返回具体的错误信息给前端
//        return R.error(message);
//    }
//}