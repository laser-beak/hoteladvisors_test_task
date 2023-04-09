package com.hoteladvisor.aincorp.zk.domain;

import javax.persistence.*;

@Entity
@Table(name = "filial_branches")
public class FilialBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Column(name = "filial_branch_address")
    private Address filialBranchAddress;

    public FilialBranch() {
    }

    public FilialBranch(String branchName, Address filialBranchAddress) {
        this.branchName = branchName;
        this.filialBranchAddress = filialBranchAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Address getFilialBranchAddress() {
        return filialBranchAddress;
    }

    public void setFilialBranchAddress(Address filialBranchAddress) {
        this.filialBranchAddress = filialBranchAddress;
    }
}

