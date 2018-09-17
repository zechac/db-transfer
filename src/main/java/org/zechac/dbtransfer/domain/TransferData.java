package org.zechac.dbtransfer.domain;

import lombok.Data;

import java.util.List;

@Data
public class TransferData {

    private List<TransferItem> mappingFields;
}
