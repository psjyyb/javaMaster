package co.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmpManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		EmpDao dao = new EmpDao();
	
		while(run) {
			System.out.println("1.사원목록 2.사원등록 3.정보수정 4.사원삭제 5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
				List<Employee> emps = dao.empList();
				System.out.println(" 사 번  이  름  이메일  급 여 ");
				System.out.println("--------------------------");
				for(Employee emp :emps) {
					System.out.println(emps.toString());
				}
				System.out.println("--------------------------");
				dao.empList();
				break;
			case 2 : 
				System.out.print("사원명 >> ");
				String name = sc.nextLine();
				System.out.print("연락처 >> ");
				String phone = sc.nextLine();
				System.out.print("이메일 >> ");
				String mail = sc.nextLine();
				System.out.print("급여 >> ");
				int salary = Integer.parseInt(sc.nextLine());
				System.out.print("입사일자 >> ");
				String hdate = sc.nextLine();
				Employee emp = new Employee();
				emp.setEmpName(name);
				emp.setPhone(phone);
				emp.setEmail(mail);
				emp.setSalary(salary);
				emp.setHiredate(hdate);
				if(dao.insertEmp(emp)) {
					System.out.println("정상 등록");
				}else {
					System.out.println("예외 발생");
				}
				break;
			case 3 : 
				System.out.print("사원 번호 >>");
				int eno = Integer.parseInt(sc.nextLine());
				System.out.print("이메일 >> ");
				 mail = sc.nextLine();
				System.out.print("급여 >> ");
				
				salary = Integer.parseInt(sc.nextLine());
				
				emp = new Employee();
				emp.setEmpno(eno);
				emp.setEmail(mail);
				emp.setSalary(salary);
				if(dao.updateEmp(emp)) {
					System.out.println("수정 완료");
				}else {
					System.out.println("수정 실패");
				}
				break;
			case 4 : 
				System.out.print("사원 번호 >>");
				eno = Integer.parseInt(sc.nextLine());
				if(dao.deleteEmp(eno)) {
					System.out.println("삭제 완료");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 5 : 
				run = false;
			}
		}
		System.out.println("end of prog.");
	}

}
