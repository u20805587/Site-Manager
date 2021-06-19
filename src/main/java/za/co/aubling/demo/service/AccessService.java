package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import sun.security.x509.OtherName;
import za.co.aubling.demo.dao.*;
import za.co.aubling.demo.domain.*;
import za.co.aubling.demo.dto.*;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccessService {

    private final SecurityWorkerRoleService securityWorkerRoleService;
    private final SecurityRoleFunctionService securityRoleFunctionService;
    private final SecurityWorkerFunctionService securityWorkerFunctionService;

    private String myDriver = "org.postgresql.Driver";
    private String myUrl = "jdbc:postgresql://localhost:5432/SiteProject";


    public AccessService(SecurityWorkerRoleService securityWorkerRoleService,
                         SecurityRoleFunctionService securityRoleFunctionService,
                         SecurityWorkerFunctionService securityWorkerFunctionService) {
        this.securityWorkerRoleService = securityWorkerRoleService;
        this.securityRoleFunctionService = securityRoleFunctionService;
        this.securityWorkerFunctionService = securityWorkerFunctionService;
    }

    public boolean grantAccess(String workerId, String functionId) throws ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException {
        Class.forName(myDriver);
        String query = "SELECT role_id FROM public.security_worker_role where worker_id = " + workerId + "'";
        Connection conn = DriverManager.getConnection(myUrl, "postgres", "Cerato#4");
        Statement st = conn.createStatement();

        query = "SELECT count(*) count FROM public.security_worker_function " +
                "where worker_id = '" + workerId +
                "' and function_id '" + functionId + "'";;
        ResultSet workerFunction = st.executeQuery(query);
        if (workerFunction.getLong("count") != 0) {
            return true;
        }

        ResultSet role = st.executeQuery(query);

        while (role.next()) {
            query = "SELECT count(*) count FROM public.security_role_function " +
                    "where role_id = '" + role.getString("role_id") +
                    "' and function_id '" + functionId + "'";;
            ResultSet roleFunction = st.executeQuery(query);
            if (roleFunction.next()){
                if (roleFunction.getLong("count") != 0){
                    return true;
                }
            }
        }
        return false;
    }
}
