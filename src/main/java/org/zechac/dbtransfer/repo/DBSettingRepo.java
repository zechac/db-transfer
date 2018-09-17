package org.zechac.dbtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zechac.dbtransfer.domain.DBSetting;

public interface DBSettingRepo extends JpaRepository<DBSetting,Integer> {
}
