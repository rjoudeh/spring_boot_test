package com.springboot.testapp.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.testapp.service.ServiceHelper.SortType;

import static com.springboot.testapp.service.ServiceHelper.SortType.*;

/**
 * 
 * @author rjoudeh
 *
 */
public class SortHelper {

	public static Sort sortByField(SortType sortType, String fieldName) {
		Direction desc = Sort.Direction.ASC;
		if (DESC == sortType)
			desc = Sort.Direction.DESC;

		return new Sort(desc, fieldName);
	}
}
