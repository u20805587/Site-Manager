package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class SecurityWorkerFunctionId implements Serializable {

    private String functionId;
    private String workerId;

    public SecurityWorkerFunctionId() {
    }

    public SecurityWorkerFunctionId(String functionId, String workerId) {
        this.functionId = functionId;
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityWorkerFunctionId securityWorkerFunctionId = (SecurityWorkerFunctionId) o;
        return functionId.equals(securityWorkerFunctionId.functionId) &&
                workerId.equals(securityWorkerFunctionId.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionId, workerId);
    }
}