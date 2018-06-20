package com.portal.service.model.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class MemberDTO {
	private int id;
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private String cancel;
	private Date join_date;
}
