package com.lg.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Model.util.DBConfig;

import com.lg.dtoSerial.DeleteUser;
import com.lg.model.dto.Cardlist;
import com.lg.model.dto.Deleteusercard;
import com.lg.model.dto.DscntInfo;
import com.lg.model.dto.Member;
import com.lg.model.dto.RecommandInputData;
import com.lg.model.dto.Storelist;
import com.lg.model.dto.UserCardJoinDscnt;
import com.lg.model.dto.Usercard;

public class GDao {

	public Boolean memberInsert(Member member) throws SQLException {
		SqlSession session = null;
		boolean commit = false;

		try {
			session = DBConfig.getSession();
			commit = session.insert("base.memberInsert", member) > 0 ? true
					: false;
		} finally {
			DBConfig.closeSession(commit, session);
		}

		return commit;
	}
	
	public Boolean memberDelete(DeleteUser deleteUser) throws SQLException{
		SqlSession session = null;
		boolean commit = false;
		
		try {
			session = DBConfig.getSession();
			commit = session.delete("base.memberDelete",deleteUser.getEmail()) > 0? true : false;
		} finally {
			DBConfig.closeSession(commit, session);
		}
		
		return commit;
	}

	public List<Member> login(String email, String passwd) throws SQLException {
		SqlSession session = null;
		List<Member> list = null;

		try {
			session = DBConfig.getSession();
			list = session.selectList("base.loginAuth", email);
		} finally {
			DBConfig.closeSession(session);
		}

		return list;
	}

	// 사용자 카드 등록
	public Boolean userCardInsert(Usercard card) throws SQLException {
		SqlSession session = null;
		boolean commit = false;

		try {
			session = DBConfig.getSession();
			commit = session.insert("base.userCardInsert", card) > 0 ? true
					: false;
		} finally {
			DBConfig.closeSession(commit, session);
		}

		return commit;
	}
	
	// 사용자 카드 삭제
	public Boolean userCardDelete(Deleteusercard card) throws SQLException{
		SqlSession session = null;
		boolean commit = false;
		
		
		try{
			session = DBConfig.getSession();
			commit = session.delete("base.userCardDelete",card) > 0 ? true : false;
		}finally{
			DBConfig.closeSession(commit,session);
		}
		
		return commit;
	}

	// 사용자 카드 목록 추출
	public List<Usercard> userCardSelect(String email) throws SQLException {
		SqlSession session = null;
		List<Usercard> list = null;

		try {
			session = DBConfig.getSession();
			list = session.selectList("base.userCardSelect", email);
		} finally {
			DBConfig.closeSession(session);
		}

		return list;
	}
	
	// Update..카드
	public Boolean isDiscount(DscntInfo discountInfo) throws SQLException {
		SqlSession session = null;
		List<DscntInfo> list = null;
		boolean result = false;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("base.isDiscount", discountInfo);
			
			//있으면 true
			if(list.size() != 0)
				result = true;
			
		} finally {
			DBConfig.closeSession(session);
		}

		return result;
	}
	
	public Boolean updateDiscount(DscntInfo discountInfo) throws SQLException {
		SqlSession session = null;
		boolean commit = false;
		
		try {
			session = DBConfig.getSession();
			commit = session.update("base.updateDiscount", discountInfo) > 0 ? true : false;
		} finally {
			DBConfig.closeSession(commit, session);
		}
		return commit;
	}
	
	// 관리자 카드 등록(최초 등록 or 직접입력시?)
	public Boolean managerCardInsert(DscntInfo discountInfo)
			throws SQLException {

		// 1. 상점을 등록
		storeInsert(discountInfo.getStoreName());
		// 2. 카드를 등록
		cardInsert(discountInfo.getCardName());
		// 3. 할인율을 등록
		SqlSession  session = null;
		boolean commit = false;
		
		try {
			session = DBConfig.getSession();
			commit = session.insert("base.insertDiscount",discountInfo) > 0 ? true : false;
		} finally {
			DBConfig.closeSession(commit, session);
		}
		
		return commit;
	}

	public Boolean storeInsert(String storeName) {
		SqlSession session = null;
		boolean commit = false;
		List<Storelist> storelist = null;

		try {
			session = DBConfig.getSession();
			// 이미 등록되어 있는지 검사.
			storelist = session.selectList("base.isStore", storeName);
						
			// 등록되어 있지 않다면.
			if (storelist.size() == 0) {
				// 등록.
				commit = session.insert("base.addStore", new Storelist(
						storeName)) > 0 ? true : false;
			}
		} finally {
			DBConfig.closeSession(commit, session);
		}

		return commit;
	}
	
	public Boolean cardInsert(String cardName) {
		SqlSession session = null;
		boolean commit = false;
		List<Cardlist> cardlist = null;

		try {
			session = DBConfig.getSession();
			// 이미 등록되어 있는지 검사.
			cardlist = session.selectList("base.isCard", cardName);
			
			// 등록되어 있지 않다면.
			if (cardlist.size() == 0) {
				// 등록.
				commit = session.insert("base.addCard", new Cardlist(
						cardName)) > 0 ? true : false;
			}
		} finally {
			DBConfig.closeSession(commit, session);
		}

		return commit;
	}
	
	// 스피너 목록을 만들어 주자!
	
	//사용처 목록
	public List<Storelist> storeList() throws SQLException {
		SqlSession session = null;
		List<Storelist> list = null;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("spinner.spinnerStore");
		} finally {
			DBConfig.closeSession(session);
		}
		return list;
	}
	//카드 목록
	public List<Cardlist> cardList() throws SQLException {
		SqlSession session = null;
		List<Cardlist> list = null;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("spinner.spinnerCard");
		} finally {
			DBConfig.closeSession(session);
		}
		return list;
	}
	
	//DSCNTINFO의 카드목록을 보여주기
	public List<DscntInfo> dscntInfoSelect() throws SQLException {
		SqlSession session = null;
		List<DscntInfo> list = null;

		try {
			session = DBConfig.getSession();
			list = session.selectList("base.dscntInfo");
		} finally {
			DBConfig.closeSession(session);
		}

		return list;
	}
	
	//Card 추천
	public List<UserCardJoinDscnt> cardRecommand(RecommandInputData inputData) throws SQLException {
		SqlSession session = null;
		List<UserCardJoinDscnt> list = null;

		try {
			session = DBConfig.getSession();
			list = session.selectList("base.recommandCard",inputData);
		} finally {
			DBConfig.closeSession(session);
		}

		return list;
	}
	
	//관리자 사람 검색.
	public List<Member> searchMember(String email) throws SQLException {
		SqlSession session = null;
		List<Member> list = null;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("base.searchMember", email);
		} finally {
			DBConfig.closeSession(session);
		}
		return list;
	}
	public List<Member> memberAll() throws SQLException {
		SqlSession session = null;
		List<Member> list = null;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("base.memberAll");
		} finally {
			DBConfig.closeSession(session);
		}
		return list;
	
	}
}
