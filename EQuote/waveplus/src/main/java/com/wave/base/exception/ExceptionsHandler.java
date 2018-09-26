package com.wave.base.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.CleanupFailureDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.stereotype.Component;

import com.wave.base.action.ClientDatatModel;
import com.wave.common.cnstants.Constants;
import com.wave.common.exception.SessionOverdueException;
@Component
public class ExceptionsHandler {
    protected transient final Logger log = LogManager.getLogger(getClass());
    // 数据库访问失败时的用户异常提示信息
    private final String DATA_ACCESS_EXCEPTION_MSG = "数据操作失败，请稍候再重试！";
    /**
     * 统一异常解析
     * 业务处理异常                                                                                                    何时抛出
     * BaseException                            所有业务处理异常都继承此异常
     * Spring的DAO异常层次 DataAccessException
     * 异常                                                                                                                何时抛出
     * CleanupFailureDataAccessException       一项操作成功地执行，但在释放数据库资源时发生异常（例如，关闭一个Connection）
     * DataAccessResourceFailureException      数据访问资源彻底失败，例如不能连接数据库
     * DataIntegrityViolationException         Insert或Update数据时违反了完整性，例如违反了惟一性限制
     * DataRetrievalFailureException           某些数据不能被检测到，例如不能通过关键字找到一条记录
     * DeadlockLoserDataAccessException        当前的操作因为死锁而失败
     * IncorrectUpdateSemanticsDataAccessException Update时发生某些没有预料到的情况，例如更改超过预期的记录数。当这个异常被抛出时，执行着的事务不会被回滚
     * InvalidDataAccessApiUsageException      一个数据访问的JAVA API没有正确使用，例如必须在执行前编译好的查询编译失败了
     * InvalidDataAccessResourceUsageException 错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库
     * OptimisticLockingFailureException       乐观锁的失败。这将由ORM工具或用户的DAO实现抛出
     * TypeMismatchDataAccessException         Java类型和数据类型不匹配，例如试图把String类型插入到数据库的数值型字段中
     * UncategorizedDataAccessException        有错误发生，但无法归类到某一更为具体的异常中
     */
    public ClientDatatModel<Object> resolveException(Exception e) {
        ClientDatatModel<Object> bDM = new ClientDatatModel<Object>();
        bDM.setCode(Constants.CONTROLLER_FAIL);
        String strMsgString = "";
        // 根据不同错误处理不同的异常信息(包括所有自定义，因为所有自定义异常都继承BaseException)
        if (e instanceof BaseException) {
            strMsgString = e.getMessage();
            log.debug(e.getMessage(), e); 
        } else if (e instanceof DataAccessException) {
            e = (Exception) e.getCause();
            log.debug("数据库访问异常！", e);
            strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            if (e instanceof CleanupFailureDataAccessException) {
                log.debug("一项操作成功地执行，但在释放数据库资源时发生异常（例如，关闭一个Connection）！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof DataAccessResourceFailureException) {
                log.debug(" 数据访问资源彻底失败，例如不能连接数据库！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof DataIntegrityViolationException) {
                log.debug("Insert或Update数据时违反了完整性，例如违反了惟一性限制！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof DataRetrievalFailureException) {
                log.debug("某些数据不能被检测到，例如不能通过关键字找到一条记录！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof DeadlockLoserDataAccessException) {
                log.debug("当前的操作因为死锁而失败！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof IncorrectUpdateSemanticsDataAccessException) {
                log.debug("Update时发生某些没有预料到的情况，例如更改超过预期的记录数。当这个异常被抛出时，执行着的事务不会被回滚！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof InvalidDataAccessApiUsageException) {
                log.debug("一个数据访问的JAVA API没有正确使用，例如必须在执行前编译好的查询编译失败了！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof InvalidDataAccessResourceUsageException) {
                log.debug("错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof OptimisticLockingFailureException) {
                log.debug("观锁的失败。这将由ORM工具或用户的DAO实现抛出！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof TypeMismatchDataAccessException) {
                log.debug("Java类型和数据类型不匹配，例如试图把String类型插入到数据库的数值型字段中！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof UncategorizedDataAccessException) {
                log.debug("有错误发生，但无法归类到某一更为具体的异常中！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
            } else if (e instanceof MyBatisSystemException) {
                log.debug("配置系统异常，请与管理员联系！", e);
                strMsgString = DATA_ACCESS_EXCEPTION_MSG;
                
            } else if (e instanceof SessionOverdueException) {
                log.debug("未登录或登陆超时，请登陆！", e);
                strMsgString = e.getMessage(); 
                bDM.setCode(Constants.CONTROLLER_SESSION_OVERDUE);
            }
        }else {
            log.debug("未知异常，请稍候再重试或请与管理员联系！", e);
            strMsgString = "未知异常，请稍候再重试或请与管理员联系！";
        }
        // TODO strMsgString中的e只用于测试阶段。
        strMsgString = strMsgString + " 异常信息：" ;
        bDM.setMsg(strMsgString);
        return bDM;
    }
}
