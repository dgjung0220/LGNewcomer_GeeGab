package com.lg.Controller;

import java.util.List;

import com.lg.Service.Service;
import com.lg.dtoSerial.DeleteUser;
import com.lg.model.dto.Cardlist;
import com.lg.model.dto.Deleteusercard;
import com.lg.model.dto.DscntInfo;
import com.lg.model.dto.Member;
import com.lg.model.dto.RecommandInputData;
import com.lg.model.dto.Storelist;
import com.lg.model.dto.UserCardJoinDscnt;
import com.lg.model.dto.Usercard;

public class Controller {
	
	public static Controller instance = new Controller();
	public Service svs = Service.getInstance();
	
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	
	//ȸ�� ����
	public Boolean memberInsert(Member member) {
		boolean result = svs.memberInsert(member);
		
		return result;
	}
	
	//�α���
	public Member login(String email, String passwd) {
		Member member = svs.login(email, passwd);
		
		return member;
	}
	
	//����� ī�� �߰�
	public Boolean userCardInsert(Usercard card) {
		boolean result = svs.userCardInsert(card);
		
		return result;
	}
	
	//����� ī�� ��� �˻�
	public List<Usercard> userCardSelect(String email) {
		return svs.userCardSelect(email);
	}
	
	//������ ī�� �߰�
	public Boolean managerCardInsert(DscntInfo discountInfo) {
		boolean result = svs.isDiscount(discountInfo);
		
		if (result) {
			// update
			return svs.updateDiscount(discountInfo);
		} else {
			// ���� ���
			return svs.managerCardInsert(discountInfo);
		}
	}
	
	//���ǳ� ���
	//���ó ���
	public List<Storelist> storeList() {
		return svs.storeList();
	}
	//ī�� ���
	public List<Cardlist> cardList() {
		return svs.cardList();
	}
	
	public List<DscntInfo> dscntInfoSelect() {
		return svs.dscntInfoSelect();
	}
	public List<UserCardJoinDscnt> cardRecommand(RecommandInputData inputData){
		return svs.cardRecommand(inputData);
	}
	public List<Member> searchMember(String email) {
		return svs.searchMember(email);
	}
	
	public List<Member> memberAll() {
		return svs.memberAll();
	}
	//ȸ�� Ż��
	public Boolean memberDelete(DeleteUser deleteuser){
		boolean result = svs.memberDelete(deleteuser);
		return result;
	}
	//ȸ�� ī�� ����
	public Boolean memberCardDelete(Deleteusercard deleteusercard){
		boolean result = svs.userCardDelete(deleteusercard);
		return result;
	}
}
