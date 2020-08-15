package com.example.resumeapi.model;
/*package com.example.model;


import com.jsw.datamodule.entities.user.Users;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

*//**
 * The persistent class for the CHAR_COMPONENT_M database table.
 *//*
@Entity
@Setter
@Getter
@Table(name = "Test")
@TableGenerator(name = "CHAR_COMPONENT_M_SEQ", table = "SEQ_GENERATOR", valueColumnName = "NEXT_VAL", allocationSize = 1)
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CHAR_COMPONENT_M_SEQ")
    @Column(name = "COMP_ID")
    private Long compId;

    @Column(name = "CHAR_NAME")
    private String charName;

    @Column(name = "COMPONENT_NAME")
    private String componentName;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "IS_FOR_COPY")
    private String isForCopy;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "CHAR_TABLE")
    private String charTable;

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @JoinColumn(name = "CHAR_NAME", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CharsMaster charsMaster;
    @JoinColumn(name = "CREATED_BY", insertable = false, updatable = false)
    @ManyToOne
    private Users createdUser;

    @JoinColumn(name = "UPDATED_BY", insertable = false, updatable = false)
    @ManyToOne
    private Users updatedUser;

}*/