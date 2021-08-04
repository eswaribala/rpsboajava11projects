package com.boa.java9.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	private String albumId;
    private long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
