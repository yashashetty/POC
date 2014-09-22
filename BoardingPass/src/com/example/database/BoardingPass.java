package com.example.database;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;



public class BoardingPass {
	 public static final String ID = "id";
	 public static final String PASS_TYPE = "type";
	@DatabaseField(generatedId = true,columnName = ID)
 public int id ;
	@DatabaseField(index = true,columnName = PASS_TYPE)
 public int type;
	@DatabaseField
  public String serialNo;
	@DatabaseField
  public Date valid_from;
	@DatabaseField
 public  Date valid_to;
	

	
  
  public BoardingPass() {
		
	}

public BoardingPass(int type,String serial_no,long from_millis, long to_millis){
	  this.type = type;
	  this.serialNo = serial_no;
	  this.valid_from = new Date(from_millis);
	  this.valid_to = new Date(to_millis);
  }

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
  
  
  
}
