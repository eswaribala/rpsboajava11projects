package com.boa.java9.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	public String albumId;
	public long id;
	public String title;
	public String url;
	public String thumbnailUrl;
	
    
}
