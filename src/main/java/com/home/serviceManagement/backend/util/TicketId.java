package com.home.serviceManagement.backend.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TicketId {

	public String timeStamp() {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String format = sdf.format(timestamp);
		String[] split = format.split("\\.");
		String timeStamp = Arrays.asList(split).stream().collect(Collectors.joining(""));
		
		return timeStamp;

	}

}
