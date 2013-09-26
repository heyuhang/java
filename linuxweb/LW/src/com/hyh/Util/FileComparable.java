package com.hyh.Util;

import java.util.Comparator;

/*
 * sort 
 */
public class FileComparable implements Comparator{

	 public int compare(Object f1, Object f2) {
         FileAndUser fl1=(FileAndUser)f1;
         FileAndUser fl2=(FileAndUser)f2;
	  return fl2.getToptime().compareTo(fl1.getToptime());
  
	 }	 
}