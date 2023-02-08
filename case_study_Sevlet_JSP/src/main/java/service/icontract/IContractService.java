package service.icontract;

import bean.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    boolean insertContract(Contract contract);
}
