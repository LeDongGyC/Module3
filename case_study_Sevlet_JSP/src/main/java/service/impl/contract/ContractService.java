package service.impl.contract;

import bean.Contract;
import repository.icontract.IContractRepository;
import repository.impl.contract.ContractRepository;
import service.icontract.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    private final IContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public boolean insertContract(Contract contract) {
        return contractRepository.insertContract(contract);
    }
}
