package com.example.afford.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long pid;
	private String productname;
    private String price;
    private String rating;
    private String discount;
    private String availability;
}
