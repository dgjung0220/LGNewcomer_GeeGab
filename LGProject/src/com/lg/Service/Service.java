package com.lg.Service;

import java.sql.SQLException;
import java.util.List;

import com.lg.Dao.GDao;
import com.lg.dtoSerial.DeleteUser;
import com.lg.model.dto.Cardlist;
import com.lg.model.dto.Deleteusercard;
import com.lg.model.dto.DscntInfo;
import com.lg.model.dto.Member;
import com.lg.model.dto.RecommandInputData;
import com.lg.model.dto.Storelist;
import com.lg.model.dto.UserCardJoinDscnt;
import com.lg.model.dto.Usercard;

public class Service {

	public static Service instance = new Service();
	public GDao gDao = new GDao();

	private Service() {
	}

	public static Service getInstance() {
		return instance;
	}

	public Boolean memberInsert(Member member) {
		Boolean result = null;

		try {
			result = gDao.memberInsert(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean memberDelete(DeleteUser deleteUser){
		Boolean result = null;
		
		try {
			result = gDao.memberDelete(deleteUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Member login(String email, String passwd) {
		List<Member> list = null;
		Member member = null;

		try {
			list = gDao.login(email, passwd);

			// 아이디가 없을 때..
			if (list.size() == 0) {
				member = new Member("존재하지 않은 아이디입니다.");
			} else if (!list.get(0).getPasswd().equals(passwd)) {
				// 아이디는 있는데, 비번이 맞지 않을 때..
				member = new Member("비밀번호가 일치하지 않습니다.");
			} else {
				// 있을 때.
				member = new Member(list.get(0).getEmail(), list.get(0)
						.getPasswd(), list.get(0).getName(), list.get(0)
						.getPhone(), list.get(0).getAddr());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	public Boolean userCardInsert(Usercard card) {
		Boolean result = null;

		try {
			result = gDao.userCardInsert(card);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//User card Delete
	public Boolean userCardDelete(Deleteusercard card){
		Boolean result = null;
		
		try {
			result = gDao.userCardDelete(card);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Usercard> userCardSelect(String email) {
		List<Usercard> list = null;

		try {
			list = gDao.userCardSelect(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Boolean managerCardInsert(DscntInfo discountInfo) {
		boolean result = false;

		try {
			result = gDao.managerCardInsert(discountInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Boolean isDiscount(DscntInfo discountInfo) {
		boolean result = false;

		try {
			result = gDao.isDiscount(discountInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateDiscount(DscntInfo discountInfo) {
		boolean result = false;

		try {
			result = gDao.updateDiscount(discountInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 스피너 목록
	// 카드 목록
	public List<Cardlist> cardList() {
		List<Cardlist> list = null;
		
		try {
			list = gDao.cardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 사용처 목록
	public List<Storelist> storeList() {
		List<Storelist> list = null;
		
		try {
			list = gDao.storeList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DscntInfo> dscntInfoSelect() {
		List<DscntInfo> list = null;
		
		try {
			list = gDao.dscntInfoSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<UserCardJoinDscnt> cardRecommand(RecommandInputData inputData){
		List<UserCardJoinDscnt> list = null;
		try {
			list = gDao.cardRecommand(inputData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//이메일 검색
	public List<Member> searchMember(String email) {
		List<Member> list = null;
		
		try {
			list = gDao.searchMember(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Member> memberAll() {
		List<Member> list = null;
		
		try {
			list = gDao.memberAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
