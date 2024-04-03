package Hello.HelloSpring.service;

import Hello.HelloSpring.repository.JpaMemberRepository;
import Hello.HelloSpring.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //@Autowired private DataSource dataSource;혹은
    //private DataSource dataSource; //이렇게도 가능하다. this is for jdbcTemplate

    /*public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @PersistenceContext
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
