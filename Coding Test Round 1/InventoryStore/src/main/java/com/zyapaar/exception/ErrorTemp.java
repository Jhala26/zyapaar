package com.zyapaar.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorTemp {

	private LocalDateTime dateTime;
	private String message;
	private String description;
	
}
