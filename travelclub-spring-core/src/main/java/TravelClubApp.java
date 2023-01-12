import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TravelClubApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* =============================================================================================
            Member 관련 메소드 테스트
        ============================================================================================== */
        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);
        // 멤버 등록
        String memberId = memberService.registerMember(new MemberCdo("sohyun@test.com", "이소현", "isohyeon", "01012341234", "960816"));
        System.out.println("ID : " + memberId);
        System.out.println();

        // 멤버 조회
        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());

        // 멤버 수정
        NameValueList nameValueList = new NameValueList();
        nameValueList.addNameValue("name","이소현수정");
        memberService.modifyMember(memberId, nameValueList);
        // 수정된 멤버 조회
        CommunityMember modifiedMember = memberService.findMemberById(memberId);
        System.out.println(modifiedMember.toString());

        // 멤버 삭제
        memberService.removeMember(memberId);
        // 삭제된 멤버 조회
        CommunityMember removedMember = memberService.findMemberById(memberId);

        /* =============================================================================================
            Club 관련 메소드 테스트

            2-6강 핵심!
            서비스 인터페이스, persistence 인터페이스 로 구성하자!
            결합도를 낮추기 위해서!
        ============================================================================================== */
//        // 새로운 club으로 regist
//        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
//        ClubService clubService = context.getBean("clubServiceLogic", ClubService.class);
//
//        // 등록 후 id 반환
//        String clubId = clubService.registerClub(clubCdo);
//        // 반환된 id로 조회
//        TravelClub foundedClub = clubService.findClubById(clubId);
//
//        System.out.println();
//        System.out.println("ID : " + clubId);
//        System.out.println();
//        System.out.println("club name : " + foundedClub.getName());
//        System.out.println("club intro : " + foundedClub.getIntro());
//        System.out.println("club foundationTime : " + foundedClub.getFoundationTime());

        /* =============================================================================================
            등록 빈 확인
        ============================================================================================== */
//        // 등록된 빈들 확인
//        // applicationContext.xml 파일에서 componentscan 작성 후
//        // @Service, @Repository 로 빈 등록 할 수 있다.
//        String[] beanNames = context.getBeanDefinitionNames();
//        System.out.println();
//        System.out.println("등록된 빈 확인 : " + Arrays.toString(beanNames));
    }
}
