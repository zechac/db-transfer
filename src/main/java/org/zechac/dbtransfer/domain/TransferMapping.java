package org.zechac.dbtransfer.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TransferMapping {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    @ManyToOne
    private DBSetting fromDB;

    @ManyToOne
    private DBSetting toDB;

    private String fromTable;

    private int pageVal;

    private String toTable;

    private String customerReadStr;

    private String customerWriteStr;

    /**
     * 映射的字段 json 格式
     * {
     *     mappingFields:[
     *     {
     *         from:"",
     *         to:""
     *     }
     *     ]
     * }
     */
    @Lob
    private String Data;
}
