package com.io.codesystem.dto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import lombok.Data;

@Entity
@Table(name="icd")
@Indexed
@Data
public class IcdCode {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @Column(name = "icd_id")
    @KeywordField
    private String icd10id;
    
    @FullTextField(analyzer = "edgengram",searchAnalyzer = "stdquery")
    @Column(name = "icd_code")
    private String icd10code;
    
    @Column(name = "icd_order")
    private String icdOrder;
    
    @Column(name = "type")
    //@KeywordField
    private String type;
   
    @FullTextField
    @Column(name = "short_desc")
    private String shortDesc;
   
    @FullTextField
    @Column(name = "medium_desc")
    private String mediumDesc;
   
    @FullTextField
    @Column(name = "long_desc")
    private String longDesc;
   
    @Column(name = "effective_from")
    private Date effectiveFrom;
   
    @Column(name = "effective_to")
    private Date effectiveTo;
   
    @Column(name = "file_id")
    private Integer fileId;
   
    @Column(name = "inserted_date")
    private Date insertedDate;
     
//    @Column(name = "parent_id")
//    private Integer parentId;
 
   /* @FullTextField(analyzer = "edgengram",searchAnalyzer = "stdquery")
    @IndexingDependency(derivedFrom = @ObjectPath(@PropertyValue(propertyName = "icd10code")))
    public String getIcd10CodePartial() {
        return icd10code;

}
    @KeywordField
    @IndexingDependency(derivedFrom = @ObjectPath(@PropertyValue(propertyName = "icd10code")))
    public String getIcd10CodeFull() {
         return icd10code;
}*/
    
  }

