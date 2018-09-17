package org.zechac.dbtransfer.domain;

import lombok.Data;
import org.zechac.dbtransfer.utils.DBType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class DBSetting {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    private String connStr;

    private String username;

    private String password;

    private DBType dbType;
}
