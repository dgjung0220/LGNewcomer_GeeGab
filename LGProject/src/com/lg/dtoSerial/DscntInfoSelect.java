package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.DscntInfo;

public class DscntInfoSelect implements Serializable {
	List<DscntInfo> list = null;
	
	public DscntInfoSelect(List<DscntInfo> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	public List<DscntInfo> getList() {
		return list;
	}

	public void setList(List<DscntInfo> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "dscntInfoSelects";
	}
}
