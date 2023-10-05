package com.app.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Owner {

	@Column(name = "profile_id")
	private String id;
	@Column(name = "profile_name")
	private String avatar_url;
	@Column(name = "profile_url")
	private String html_url;
	private String type;
	private String site_admin;
	
	
	
}
