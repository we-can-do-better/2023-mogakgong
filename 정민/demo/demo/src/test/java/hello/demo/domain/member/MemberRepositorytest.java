package hello.demo.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositorytest {

     MemberRepository memberRepository = MemberRepository.getInstance();

     @AfterEach
    void afterEach()
     {
         memberRepository.clearStore();
     }

     @Test
    void save() {


         Member member = new Member("hello",20);
         Member savedMember = memberRepository.save(member);

         Member findMember = memberRepository.findById(savedMember.getId());

         Assertions.assertThat(findMember).isEqualTo(savedMember);
     }

     @Test
    void findAll()
     {
         Member member1= new Member("member1",20);
         Member member2 = new Member("member2",30);
         memberRepository.save(member1);
         memberRepository.save(member2);

         List<Member> result = memberRepository.findAll();
         Assertions.assertThat(result.size()).isEqualTo(2);

     }
}
