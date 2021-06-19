package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class SecurityWorkerFunctionId implements Serializable {

    private String workerId;
    private String functionId;

    public SecurityWorkerFunctionId() {
    }

    public SecurityWorkerFunctionId(String workerId, String functionId) {
        this.workerId = workerId;
        this.functionId = functionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityWorkerFunctionId securityWorkerFunctionId = (SecurityWorkerFunctionId) o;
        return workerId.equals(securityWorkerFunctionId.workerId) &&
                functionId.equals(securityWorkerFunctionId.functionId)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId,functionId);
    }
}