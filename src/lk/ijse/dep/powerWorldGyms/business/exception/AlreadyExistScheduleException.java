package lk.ijse.dep.powerWorldGyms.business.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AlreadyExistScheduleException extends MySQLIntegrityConstraintViolationException {

    public AlreadyExistScheduleException(String message){
        super(message);
    }


}
