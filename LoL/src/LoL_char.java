import java.util.Scanner;

/**
 * @LoL_char() : 게임정보를 담는 클래스
 * @name : 유닛의 이름
 * @ad :   유닛의 공격력
 * @def :  유닛의 방어력
 * @hp :   유닛의 체력
 * */
class LoL_char {


    //TODO:
    // 사용자의 입력을 받기위한 객체 생성을 진행합니다.

    // 게임에 필요한 변수 타입을 사전 정의합니다.
    String name;// 전역변수 이름.공격력,방어력,체력 선언
    String ad;
    String def;
    String hp;
    /**
     * @user_info : 생성된 유닛의 정보를 담는 메서드
     * @this : 해당 메서드가 입력받은 변수들은 this 를
     */
    void user_info(String name, String ad, String def, String hp) {// user_create()
        this.name = name; //전역변수에 선언된 변수와 user_info 매개변수에 있는 변수가 이름이 똑같음.그래서 이거를 구분해주기위해서 this를 쓰는데 좌변에 있는게 전역변수에서의 name이고 이 전역변수name에다가 user_info 의 매개변수를 할당해주겟다.
        this.ad = ad;
        this.def = def;
        this.hp = hp;
    }


    /**
     * @user_create() : 유닛을 생성하는 메서드이며, 입력된 값은 user_info() 메서드에게 전달 및 반환 처리합니다.
     * 반환된 값은 시스템 정보창에 출력되도록 합니다.
     * */
    String[] user_create() {
        //TODO:
        Scanner s = new Scanner(System.in); // Scanner라는 클래스를 변수s에 담아서 인스턴스화 시키겟다.
        //입력 메시지와 함께, 게임에 필요한 유닛의 정보를 입력받습니다.
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 :");
        String name = s.nextLine(); // name이라는 문자열타입을 선언해주고 걔에다가 변수s에 입력받은거를 넣어주겟다.

        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : ");
        String ad = s.nextLine();

        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : " );
        String def = s.nextLine();

        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : " );
        String hp = s.nextLine();
        // 입력된 값은 user_info()에 전달하여 줍니다.
        user_info(name,ad,def,hp); // 위의 입력받아놓은 4개의 변수들을 user_info메서드에 전달하여 줌.
        // 유저마다의 객체 생성을 위해 반환 과정 또한 정의하여 줍니다.
        String[] userInfo = {this.name,this.ad,this.def,this.hp}; // userInfo 문자열배열 선언, 그 배열에는 name,ad,def,hp생성자를 담아줌.

        return userInfo; //위에 선언해준 userInfo를 리턴해줌
    }

    /**
     * @user_print() : 입력된 배열을 통해 유닛 정보 출력
     * */
    void user_print(String[] user) { // user라는 문자열배열을 매개변수로 가지고 있고 반환값은 없는 user_print메서드
        //TODO:
        System.out.println("[시스템] 유닛 정보가 정상적으로 생성되었습니다.");
        System.out.println("[시스템] 유닛 [이름] : " + user[0]); //user배열이 위에 메서드와 연결이 안되어 있긴하지만 LOL_Program코드에서 연결이 되어있슴
        System.out.println("[시스템] 유닛 [공격력] : " + user[1]);
        System.out.println("[시스템] 유닛 [방어력] : " + user[2]);
        System.out.println("[시스템] 유닛 [체력] : " + user[3]);
    }

    /**
     * @user_info_int() : 공격력과 방어력 등을 고려해 체력 감소를 위해 문자열을 정수형태로 전환합니다.
     * Integer.parseInt() : 정수형태로 전환합니다.
     */
    int[] user_info_int(String[] info) { //info라는 문자열배열을 매개변수로 하고있고 반환값은 정수형배열인 메서드
        //TODO:
        // 같은 형식의 반환을 위해 배열 선언
        int[] infoInt = new int[info.length]; //정수형배열을 반환해줘야 하므로 infoInt라는 정수형배열을 선언해주고 그걸 인스턴스화시킴 근데 그 사이즈는 info(문자열배열)의 길이 만큼임.
        // 배열의 값을 하나씩 꺼내 정수형태로 전환합니다.
        for(int i = 1; i<info.length;i++){ // i를 0부터로 하면 name인데 name은 정수화 시킬수가 없으므로 오류가 발생. 따라서 숫자로 바꿀수 있는 1부터 문자열배열이 끝날떄까지 for문 순회
            infoInt[i] = Integer.parseInt(info[i]); // infoInt정수형 배열에 info[i]를 정수형태로 전환해준거를 넣어줌.
        }
        return infoInt; //for문 순회하고 나온 infoInt를 반환해줌
    }


    /**
     * @attack() : 공격을 수행하는 메서드
     * 아군 유닛 정보와 상대의 정보를 입력받습니다.
     * */
    void attack(int[] me_info_int, int[] enemy) {// me_info_int(아군유닛정보)와 enemy(상대의정보)의 정수형 배열을 매개변수로 하고있는 아무것도 반환하지않는 메서드
        // 조건 1. 적군의 체력이 0 이하면 [유닛 제거] 가 됩니다.
        // 조건 2. 적군 체력이 0 이하가 아니라면 공격을 성공적으로 수행합니다.
        // 공격 정책 수식 : 적군 체력 -= 아군 유닛 공격력 / 적군 유닛 방어력
        //TODO:
        while(enemy[3] >=0){ // 적의 체력이 0이상일때는 계속 순회 while문 안에서 적체력이 0이될때까지 줄기떄문에 그때 순회 종료
            int damage = me_info_int[1] / enemy[2]; //위의 공격 정책 수식대로 damage라는 정수형 변수 선언해주고 거기에는 아군 유닛 공격력 / 적군 유닛 방어력 을 담음
            enemy[3]-= damage; //적군 체력 -= damage;
            if(enemy[3]<0){ // 적군 체력이 0보다 작을 경우 다음 메세지 출력
                System.out.println("[안내] 더 이상 공격할 수 없습니다.");
                System.out.println();
                System.out.println("[시스템] 적군 유닛이 제거되었습니다.");
            }else { // 0보다 클경우 다음 메세지 출력
                System.out.println("[안내] [" + name +"]유닛이 [공격] 하였습니다.");
                System.out.println("[안내] 상대 유닛의 남은 [체력]은 " + enemy[3] +" 입니다.");
            }
        }
    }
}