package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// DTO
class CafeDto {

    private String menuName;
    private String password;
    private int stock;

    public CafeDto() { super(); }

    public CafeDto(String menuName, String password, int stock) {
        super();
        this.menuName = menuName;
        this.password = password;
        this.stock = stock;
    }

    @Override public String toString() { 
    		return "[ menuName=" + menuName + ", password=" + password + ", stock=" + stock + " ]"; }

    public String getMenuName() { return menuName; }  
    public void setMenuName(String menuName) { this.menuName = menuName; }

    public String getPassword() { return password; }  
    public void setPassword(String password) { this.password = password; }

    public int getStock() { return stock; }  
    public void setStock(int stock) { this.stock = stock; }

    @Override public int hashCode() { return Objects.hash(menuName); }
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CafeDto other = (CafeDto) obj;
        return Objects.equals(menuName, other.menuName);
    }
}

// Controller
class Cafe {

    List<CafeDto> menus;

    public Cafe() { super(); }

    public Cafe(List<CafeDto> menus) {
        super();
        this.menus = menus;
    }

    Scanner sc = new Scanner(System.in);

    // 메뉴 출력
    public void menu() {

        System.out.println(menus);

        System.out.print(
            "\n -- cafe menu --\n\n"
			+ "1. 메뉴 등록\r\n"
			+ "2. 전체 메뉴 확인\r\n"
			+ "3. 재고 확인 / 입고\r\n"
			+ "4. 메뉴 판매\r\n"
			+ "5. 메뉴 삭제\r\n"
			+ "6. 인기 음료 조회\r\n"
			+ "7. 관리자 로그인\r\n"
			+ "9. 종료"
			+ "\r\n"+">> 번호를 선택하세요: "
        );
    }

    // 메뉴 등록
    public void add() {

        String menuName;
        String password;
        int stock;
        int check = -1;

        System.out.print("메뉴명 : ");
        menuName = sc.next();

        // 중복 검사
        for (int i = 0; i < menus.size(); i++) {

            if (menuName.equals(menus.get(i).getMenuName())) {
                check = 1;
                break;
            }
        }

        if (check == -1) {
     /////// 관리자 로그인으로 대체
            System.out.print("관리 비밀번호 : ");
            password = sc.next();

            do {
                System.out.print("재고 수량 : ");
                stock = sc.nextInt();
            } while (stock < 0);

            menus.add(new CafeDto(menuName, password, stock));

            System.out.println("메뉴 등록 완료!");

        } else {

            System.out.println("이미 존재하는 메뉴입니다.");
        }
    }

    // 메뉴 확인 -> 전체메뉴출력
    public CafeDto menuCheck() {

        String menuName;
        String password;

        CafeDto find = null;

        System.out.print("메뉴명 : ");
        menuName = sc.next();

        System.out.print("관리 비밀번호 : ");
        password = sc.next();

        for (int i = 0; i < menus.size(); i++) {

            if (menus.get(i).getMenuName().equals(menuName)
                    && menus.get(i).getPassword().equals(password)) {

                find = menus.get(i);
                break;
            }
        }

        return find;
    }

    // 재고 조회 입고랑 합치기
    public void stock(CafeDto find) {

        System.out.println("현재 재고 : "
                + find.getStock() + "개");
    }

    // 재고 입고
    public void addStock(CafeDto find) {

        System.out.print("입고 수량 : ");
        int amount = sc.nextInt();

        if (amount >= 0) {

            int stock = find.getStock();

            stock += amount;

            find.setStock(stock);

            System.out.println("입고 완료!");
            System.out.println("현재 재고 : " + stock);

        } else {

            System.out.println("음수 입력 불가");
        }
    }

    // 메뉴 주문
    public void sell(CafeDto find) {

        System.out.print("판매 수량 : ");
        int amount = sc.nextInt();

        int stock = find.getStock();

        if (amount >= 0 && stock - amount >= 0) {

            stock -= amount;

            find.setStock(stock);

            System.out.println("판매 완료!");
            System.out.println("남은 재고 : " + stock);

        } else {

            System.out.println("재고 부족");
        }
    }

    // 메뉴 삭제
    public void delete(CafeDto find) {

        System.out.print("메뉴를 삭제하시겠습니까? (y/n) : ");

        char answer = sc.next().charAt(0);

        if (answer == 'y') {

            menus.remove(find);

            System.out.println("메뉴 삭제 완료!");

        } else if (answer == 'n') {

            System.out.println("삭제 취소");
        }
    }
    
    // 인기 음료 조회
    public void bestdrink() {
    	
    }
    // 관리자 회원가입
    public String[] admin() {

        String[] admin = new String[2];

        System.out.print("관리자 아이디 : ");
        admin[0] = sc.next();

        System.out.print("관리자 비밀번호 : ");
        admin[1] = sc.next();

        System.out.println("관리자 회원가입 완료!");

        return admin;
    }
    // 관리자 로그인
    public boolean mlogin(String adminId, String adminPw) {
    	String id;	String pw;

        System.out.print("아이디 : "); id = sc.next();
        System.out.print("비밀번호 : "); pw = sc.next();
    	
        if(id.equals(adminId) && pw.equals(adminPw)) {
            System.out.println("로그인 성공!");
            return true;
        }
        System.out.println("로그인 실패");
        return false;
    }
}

// Main
public class Cafe_Manage_ver2 {

    public static void main(String[] args) {

        List<CafeDto> menus = new ArrayList<>();

        Cafe controller = new Cafe(menus);

        Scanner sc = new Scanner(System.in);

        int menu = -1;
        boolean login = false; String adminId = null;  String adminPw = null;

        System.out.println("\n 🌟☕ Welcome To Cafe ☕🌟\n");

        while (menu != 9) {
            controller.menu();
            menu = sc.nextInt();

            if (menu == 9) {
                System.out.println("프로그램 종료");
            }
            else if (menu == 1) {
                controller.add();
            }
            else if (menu >= 2 && menu <= 5) {

                CafeDto find = controller.menuCheck();

                if (find == null) {
                    System.out.println("메뉴 정보를 확인해주세요.");
                    continue;
                }

                switch (menu) {
                    case 2: controller.stock(find); break;
                    case 3: controller.addStock(find); break;
                    case 4: controller.sell(find); break;
                    case 5: controller.delete(find); break;
                    case 6: controller.bestdrink(); break;
                    default: System.out.println("잘못된 입력"); break;
                }

            } else if(menu == 7) {

                // 가입 정보 없음
                if(adminId == null || adminPw == null) {

                    System.out.println("회원가입이 필요합니다.");

                    String[] admin = controller.admin();

                    adminId = admin[0];
                    adminPw = admin[1];
                }

                // 로그인 진행
                login = controller.mlogin(adminId, adminPw);
            } else {

                System.out.println("잘못된 번호 입력");
            }
        }
    }
}