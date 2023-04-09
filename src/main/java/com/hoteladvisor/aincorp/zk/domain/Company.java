package com.hoteladvisor.aincorp.zk.domain;

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
    @Column(name = "company_address")
    private Address companyAddress;

    @OneToMany(mappedBy = "filial_branch")
    private List<FilialBranch> companyBranches;

    public Company() {
    }

    public Company(String companyName, LegalFormType legalFormType, Address companyAddress, List<FilialBranch> companyBranches) {
        this.companyName = companyName;
        this.legalFormType = legalFormType;
        this.companyAddress = companyAddress;
        this.companyBranches = companyBranches;
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

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<FilialBranch> getCompanyBranches() {
        return companyBranches;
    }

    public void setCompanyBranches(List<FilialBranch> companyBranches) {
        this.companyBranches = companyBranches;
    }
}
