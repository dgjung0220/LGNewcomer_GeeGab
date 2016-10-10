package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.UserCardJoinDscnt;

public class RecommandSelect implements Serializable {
	List<UserCardJoinDscnt> list = null;

	public List<UserCardJoinDscnt> getList() {
		return list;
	}

	public void setList(List<UserCardJoinDscnt> list) {
		this.list = list;
	}

	public RecommandSelect(List<UserCardJoinDscnt> list) {
		super();
		this.list = list;
	}
}
