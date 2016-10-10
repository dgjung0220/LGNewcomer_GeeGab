package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.Cardlist;

public class CardlistSelect implements Serializable {
	List<Cardlist> list = null;

	public List<Cardlist> getList() {
		return list;
	}

	public void setList(List<Cardlist> list) {
		this.list = list;
	}

	public CardlistSelect(List<Cardlist> list) {
		super();
		this.list = list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "cardListSelect";
	}
}
