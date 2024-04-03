package Hello.HelloSpring.service;

import Hello.HelloSpring.repository.JdbcMemberRepository;
import Hello.HelloSpring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //@Autowired private DataSource dataSource;혹은
    private DataSource dataSource; //이렇게도 가능하다.

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
