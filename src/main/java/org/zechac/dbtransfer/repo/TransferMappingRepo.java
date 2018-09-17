package org.zechac.dbtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zechac.dbtransfer.domain.TransferMapping;

public interface TransferMappingRepo extends JpaRepository<TransferMapping,Integer> {
}
