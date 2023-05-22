package com.hoteladvisor.aincorp.zk.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Enumerated(EnumType.STRING)
    @Column(name = "legalform_type")
    private LegalFormType legalFormType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FilialBranch> filialBranches;

    public Company() {
    }

    public Company(String companyName, LegalFormType legalFormType, Address address, List<FilialBranch> filialBranches) {
        this.companyName = companyName;
        this.legalFormType = legalFormType;
        this.address = address;
        this.filialBranches = filialBranches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LegalFormType getLegalFormType() {
        return legalFormType;
    }

    public void setLegalFormType(LegalFormType legalFormType) {
        this.legalFormType = legalFormType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<FilialBranch> getFilialBranches() {
        return filialBranches;
    }

    public void setFilialBranches(List<FilialBranch> filialBranches) {
        this.filialBranches = filialBranches;
    }
}
