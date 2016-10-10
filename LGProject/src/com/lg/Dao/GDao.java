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

	// ����� ī�� ���
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
	
	// ����� ī�� ����
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

	// ����� ī�� ��� ����
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
	
	// Update..ī��
	public Boolean isDiscount(DscntInfo discountInfo) throws SQLException {
		SqlSession session = null;
		List<DscntInfo> list = null;
		boolean result = false;
		
		try {
			session = DBConfig.getSession();
			list = session.selectList("base.isDiscount", discountInfo);
			
			//������ true
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
	
	// ������ ī�� ���(���� ��� or �����Է½�?)
	public Boolean managerCardInsert(DscntInfo discountInfo)
			throws SQLException {

		// 1. ������ ���
		storeInsert(discountInfo.getStoreName());
		// 2. ī�带 ���
		cardInsert(discountInfo.getCardName());
		// 3. �������� ���
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
			// �̹� ��ϵǾ� �ִ��� �˻�.
			storelist = session.selectList("base.isStore", storeName);
						
			// ��ϵǾ� ���� �ʴٸ�.
			if (storelist.size() == 0) {
				// ���.
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
			// �̹� ��ϵǾ� �ִ��� �˻�.
			cardlist = session.selectList("base.isCard", cardName);
			
			// ��ϵǾ� ���� �ʴٸ�.
			if (cardlist.size() == 0) {
				// ���.
				commit = session.insert("base.addCard", new Cardlist(
						cardName)) > 0 ? true : false;
			}
		} finally {
			DBConfig.closeSession(commit, session);
		}

		return commit;
	}
	
	// ���ǳ� ����� ����� ����!
	
	//���ó ���
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
	//ī�� ���
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
	
	//DSCNTINFO�� ī������ �����ֱ�
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
	
	//Card ��õ
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
	
	//������ ��� �˻�.
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
