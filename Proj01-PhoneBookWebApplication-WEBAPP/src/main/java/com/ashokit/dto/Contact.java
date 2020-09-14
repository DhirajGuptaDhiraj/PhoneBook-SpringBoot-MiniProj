package com.ashokit.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Contact{
 @Id
 private Integer cid;
 private String cname;
 private String cnum;
 private String email;
}