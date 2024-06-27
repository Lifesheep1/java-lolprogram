
public class LOL_Program {
    public static void main(String[] args) {
        //TODO:
        LoL_char user = new LoL_char(); //  LoL_char클래스를 인스턴스화 하고 user라는 객체 생성
        LoL_char enemy = new LoL_char(); // enemy객체 생성
        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
        String[] userInfo = user.user_create(); // userInfo라는 문자열 배열 선언, 거기에는 user객체의 user_create()메서드가 들어감 그리고 user_create()메서드 실행시키고 호출
        System.out.println();
        user.user_print(userInfo);//user의 정보를 입력받은거를 출력함. user_print메서드를 통해서 출력하는데 그 매개변수는 위에서 선언한 문자열 배열 userInfo임.
        int[] userinfoint = user.user_info_int(userInfo); // userinfoint라는 정수형 배열 선언, 거기에는 user객체의 user_info_int(userInfo)를 실행시키고 호출함. 그래서 입력받았던 숫자값들을 계산할수있게 정수형으로 변환.

        System.out.println("========================================");
        System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
        String[] enemyInfo = enemy.user_create(); // 마찬가지로 적군것도 위처럼 입력받아줌. enemy객체를 사용.
        System.out.println();
        enemy.user_print(enemyInfo);
        int[] enemyinfoint = enemy.user_info_int(enemyInfo);
        System.out.println("========================================");
        System.out.println("----------------------------------------");
        user.attack(userinfoint,enemyinfoint);// user가 enemy를 공격하는 것이므로 attack메서드앞에 user객체를 붙여줌. 매개변수는 해당 메서드를 보면 user정보 먼저받고 후에 적군정보 받음
        System.out.println("----------------------------------------");
    }
}