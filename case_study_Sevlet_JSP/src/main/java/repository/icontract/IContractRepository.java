package repository.icontract;

import bean.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> findAll();
    boolean insertContract(Contract contract);
}
