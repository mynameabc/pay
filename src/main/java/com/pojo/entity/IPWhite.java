package com.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "ip_white")
public class IPWhite implements java.io.Serializable {

    private static final long serialVersionUID = 6838410450574669112L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "merchant_no")
    private Integer merchantNo;

    @Column(name = "ip_addr")
    private String IpAddr;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private Long type;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;
}
