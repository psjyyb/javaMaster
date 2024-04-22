package co.yedam;

import java.util.*;

public class SwimMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		SwimDao dao = new SwimDao();
		while (run) {
			System.out.println("1.회원목록 2.회원등록 3.정보수정 4.정보삭제 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택 >");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				List<Swim> swims = dao.swim();
				System.out.println("회원번호  회원명    회원연락처    회원생일    성별");
				System.out.println("----------------------------------");
				for (Swim sw : swims) {
					System.out.println(sw.toString());
				}
				System.out.println("----------------------------------");
				break;
			case 2:
				System.out.print("회원명 >> ");
				String name = sc.nextLine();
				System.out.print("회원연락처 >> ");
				String phone = sc.nextLine();
				System.out.print("회원생년월일 >> ");
				String day = sc.nextLine();
				System.out.print("성별 >> ");
				String gen = sc.nextLine();
				Swim swim = new Swim();
				swim.setMemName(name);
				swim.setMemPhone(phone);
				swim.setMemDay(day);
				swim.setGender(gen);
				if (dao.insertSwim(swim)) {
					System.out.println("정상 등록");
				} else {
					System.out.println("예외 발생");
				}
				break;
			case 3:
				System.out.print("회원번호 >> ");
				int mno = Integer.parseInt(sc.nextLine());
				System.out.print("회원명 >> ");
				String mname = sc.nextLine();
				System.out.print("전화번호 >> ");
				String mphone = sc.nextLine();
				swim = new Swim();
				swim.setMemNumber(mno);
				swim.setMemName(mname);
				swim.setMemPhone(mphone);
				if (dao.updateSwim(swim)) {
					System.out.println("정상 수정");
				} else {
					System.out.println("예외 발생");
				}
				break;
			case 4:
				System.out.print("회원번호 >> ");
				mno = Integer.parseInt(sc.nextLine());
				if(dao.deleteSwim(mno)) {
					System.out.println("정상 삭제");
				}else {
					System.out.println("예외 발생");
				}
				break;
			case 5:
			break;
			case 6: 
					run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
