package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.Cardlist;
import com.lg.model.dto.DscntInfo;
import com.lg.model.dto.Storelist;

public class SpinnerList implements Serializable{
	List<Storelist> storelist = null;
	List<Cardlist> cardlist = null;
	List<DscntInfo> list = null;
	
	public SpinnerList() {}
	
	
	public SpinnerList(List<Storelist> storelist, List<Cardlist> cardlist, List<DscntInfo> list) {
		super();
		this.storelist = storelist;
		this.cardlist = cardlist;
		this.list = list;
	}
	
	public List<Storelist> getStorelist() {
		return storelist;
	}

	public void setStorelist(List<Storelist> storelist) {
		this.storelist = storelist;
	}

	public List<Cardlist> getCardlist() {
		return cardlist;
	}

	public void setCardlist(List<Cardlist> cardlist) {
		this.cardlist = cardlist;
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
		return "SpinnerList";
	}
}
