package com.lg.SocketServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.lg.Controller.Controller;
import com.lg.dtoSerial.CardlistSelect;
import com.lg.dtoSerial.DeleteUser;
import com.lg.dtoSerial.Login;
import com.lg.dtoSerial.MemberSelect;
import com.lg.dtoSerial.RecommandSelect;
import com.lg.dtoSerial.Register;
import com.lg.dtoSerial.SearchStringToken;
import com.lg.dtoSerial.SpinnerList;
import com.lg.dtoSerial.UserCardSelect;
import com.lg.dtoSerial.UserCardSelectResult;
import com.lg.model.dto.Cardlist;
import com.lg.model.dto.Deleteusercard;
import com.lg.model.dto.DscntInfo;
import com.lg.model.dto.Member;
import com.lg.model.dto.RecommandInputData;
import com.lg.model.dto.UserCardJoinDscnt;
import com.lg.model.dto.Usercard;

public class NetworkServer {

	public static void main(String[] args) {
		Controller con = Controller.getInstance();

		try {
			int port = 11001;

			System.out.println("Starting Java Socket Server...");
			ServerSocket aServerSocket = new ServerSocket(port);
			System.out.println("Listening at port " + port + "...");

			// 최초 한번 카드 할인율 등록

			while (true) {
				Socket sock = aServerSocket.accept();
				InetAddress clientHost = sock.getLocalAddress();
				int clientPort = sock.getPort();
				System.out.println("A client connected. host : " + clientHost
						+ ", port : " + clientPort);

				ObjectInputStream instream = new ObjectInputStream(
						sock.getInputStream());
				Object data = instream.readObject();

				// 로그인 처리
				if (data.toString().equals("Login")) {
					System.out.println("-----------로그인 input-----------");
					System.out.println("이메일 : " + ((Login) data).getEmail());
					System.out.println("패스워드 : " + ((Login) data).getPasswd());

					Member member = con.login(((Login) data).getEmail(),
							((Login) data).getPasswd());

					System.out.println("------------output----------");
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(member);
					outStream.flush();

					System.out.println(member.getEmail());
					System.out.println(member.getPasswd());
					System.out.println(member.getName());
					System.out.println(member.getAddr());

				} else if (data.toString().equals("Register")) {
					System.out.println("-----------회원 가입 input-----------");
					System.out.println(((Register) data).getEmail());
					System.out.println(((Register) data).getPasswd());
					System.out.println(((Register) data).getName());
					System.out.println(((Register) data).getPhone());
					System.out.println(((Register) data).getAddr());

					boolean result = con.memberInsert(new Member(
							((Register) data).getEmail(), ((Register) data)
									.getPasswd(), ((Register) data).getName(),
							((Register) data).getPhone(), ((Register) data)
									.getAddr()));

					System.out.println("-----------output-----------");
					String res = result == true ? "성공" : "실패";
					System.out.println("결과 : " + res);

					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(res);
					outStream.flush();

				} else if (data.toString().equals("userCard")) {
					System.out.println("-----------카드 추가 input-----------");
					System.out.println("이메일" + ((Usercard) data).getEmail());
					System.out.println("카드명" + ((Usercard) data).getCardName());
					System.out.println("카드 타입"
							+ ((Usercard) data).getCardType());
					System.out.println("카드 번호" + ((Usercard) data).getCardID());
					System.out.println("카드 별칭"
							+ ((Usercard) data).getCardAlias());
					
					
					boolean result = con.userCardInsert(new Usercard(
							((Usercard) data).getCardID(), ((Usercard) data)
									.getEmail(), ((Usercard) data)
									.getCardName(), ((Usercard) data)
									.getCardType(), ((Usercard) data)
									.getCardAlias()));

					String res = result == true ? "성공" : "실패";
					System.out.println("결과 : " + res);

					// 안드로이드로 리턴

				} else if (data.toString().equals("userCardSelect")) {
					System.out.println("-----------카드 목록 input-----------");
					System.out.println("접속 ID"
							+ ((UserCardSelect) data).getEmail());

					List<Usercard> list = con
							.userCardSelect(((UserCardSelect) data).getEmail());
					UserCardSelectResult result = new UserCardSelectResult(list);
					
					
					
					System.out.println("-----------output-----------");
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(result);
					outStream.flush();
					for (int i = 0; i < result.getList().size(); i++) {
						System.out.print(result.getList().get(i).getEmail()
								+ " | ");
						System.out.print(result.getList().get(i).getCardID()
								+ " | ");
						System.out.print(result.getList().get(i).getCardName()
								+ " | ");
						System.out.print(result.getList().get(i).getCardType()
								+ " | ");
						System.out.println(result.getList().get(i)
								.getCardAlias());
					}
				} else if (data.toString().equals("DscntInfo")) {
					System.out.println("-----------관리자 카드 추가 input-----------");
					System.out.println("사용처 : "
							+ ((DscntInfo) data).getStoreName());
					System.out.println("카드명 : "
							+ ((DscntInfo) data).getCardName());
					System.out.println("할인율 : "
							+ ((DscntInfo) data).getDiscountRate());

					boolean result = con.managerCardInsert(new DscntInfo(((DscntInfo) data)
							.getCardName(), ((DscntInfo) data).getStoreName(),
							((DscntInfo) data).getDiscountRate()));
					System.out.println("-----------output-----------");
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(result);
					outStream.flush();

					String res = result == true ? "성공" : "실패";
					System.out.println("결과 : " + res);
				} else if (data.toString().equals("adminCard")) {
					System.out.println("-----------관리자 스피너 목록 만들기 input-----------");
					SpinnerList list = new SpinnerList(con.storeList(), con.cardList(), con.dscntInfoSelect());
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(list);
					outStream.flush();
					System.out.println("-----------관리자 스피너 목록 & 카드목록 만들기 output-----------");
					
					for(int i = 0; i < list.getStorelist().size(); i++) {
						System.out.print(list.getStorelist().get(i).getStoreName() + " | ");
					}
					System.out.println();
					for(int i = 0; i < list.getCardlist().size(); i++) {
						System.out.print(list.getCardlist().get(i).getCardName() + " | ");
					}
					System.out.println();
					System.out.println("-----------관리자 카드 목록 만들기 output-----------");
					for(int i = 0; i < list.getList().size(); i++) {
						System.out.print(list.getList().get(i) + " | ");
					}
					System.out.println();
				} else if (data.toString().equals("cardListSelect")) {
					List<Cardlist> cardlist = con.cardList();
					for(int i = 0; i< cardlist.size(); i++) {
						System.out.print(cardlist.get(i) +" | ");
					}
					System.out.println();
					System.out.println("-----------output-----------");
					CardlistSelect list = new CardlistSelect(cardlist);
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(list);
					outStream.flush();
					
					for(int i = 0; i< list.getList().size(); i++) {
						System.out.print(list.getList().get(i) +" | ");
					}
					System.out.println();
				} else if(data.toString().equals("RecommandInputData")){
					List<UserCardJoinDscnt> list = con.cardRecommand((RecommandInputData)data);
					RecommandSelect returnlist = new RecommandSelect(list);
					System.out.println("-----------output-----------");
					
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(returnlist);
					outStream.flush();
					for(int i = 0; i< returnlist.getList().size(); i++) {
						System.out.print(returnlist.getList().get(i).getCardAlias() +" | "
								+returnlist.getList().get(i).getCardID() +" | "
								+returnlist.getList().get(i).getDiscountRate());
					}
					System.out.println();
				} else if (data.toString().equals("memberAll")) {
					List<Member> list = con.memberAll();
					MemberSelect returnlist = new MemberSelect(list);
					System.out.println("-----------전체 멤버 출력 input-----------");
					
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(returnlist);
					outStream.flush();
					
				} else if(data.toString().equals("SearchStringToken")) {
					List<Member> list = con.searchMember(((SearchStringToken)data).getToken());
					MemberSelect returnlist = new MemberSelect(list);
					System.out.println("-----------멤버 검색 input-----------");
					
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(returnlist);
					outStream.flush();
					
					for(int i =0; i< returnlist.getList().size(); i++){
						System.out.print(returnlist.getList().get(i).getEmail() +" | "
								+returnlist.getList().get(i).getName() +" | "
								+returnlist.getList().get(i).getPhone());
					}
				} else if(data.toString().equals("deleteuser")) {
					System.out.println("-----------삭제 유저 input-----------");
					System.out.println("접속 ID"+((DeleteUser)data).getEmail());
					System.out.println("ID PW"+((DeleteUser)data).getPasswd());
					
					boolean result = con.memberDelete((DeleteUser)data);
					System.out.println("-----------output-----------");
					
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(result);
					outStream.flush();
					
					String res = result == true ? "성공":"실패";
					System.out.println("결과 : "+res);
				} else if(data.toString().equals("deleteuserCard")){
					System.out.println("-----------삭제 유저 카드 input-----------");
					System.out.println("접속 ID"+((Deleteusercard)data).getEmail());
					System.out.println("삭제할 카드 ID"+((Deleteusercard)data).getCardID());
					
					boolean result = con.memberCardDelete((Deleteusercard)data);
					System.out.println("-----------output-----------");
					
					ObjectOutputStream outStream = new ObjectOutputStream(
							sock.getOutputStream());
					outStream.writeObject(result);
					outStream.flush();
					
					String res = result == true ? "성공" : "실패";
					System.out.println("결과 : " + res);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
