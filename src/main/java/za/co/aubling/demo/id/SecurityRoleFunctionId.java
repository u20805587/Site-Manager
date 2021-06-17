package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class SecurityRoleFunctionId implements Serializable {

    private String roleId;
    private String functionId;

    public SecurityRoleFunctionId() {
    }

    public SecurityRoleFunctionId(String roleId, String functionId) {
        this.roleId = roleId;
        this.functionId = functionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityRoleFunctionId securityRoleFunctionId = (SecurityRoleFunctionId) o;
        return roleId.equals(securityRoleFunctionId.roleId) &&
                functionId.equals(securityRoleFunctionId.functionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, functionId);
    }
}