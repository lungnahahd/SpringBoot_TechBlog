package Lungnaha.MyFirstSpring.Repository;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Interface.DBInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//JDBC 템플릿을 활용한 저장소 인터페이스 기능 부여
public class TemplateJDBC implements DBInterface {
    private final JdbcTemplate jdbcTemplate;

    public TemplateJDBC(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource); // jdbc 템플릿 생성자 처리 -> DataSource를 통해서 DB 연결
    }

    // 데이터를 저장하는 부분
    @Override
    public Member Save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("testtable").usingGeneratedKeyColumns("id"); // Table에서 자동 id 생성 시에 추가하는 코드

        Map<String, Object> parameters = new HashMap<>();
        // 인자로 받은 Member를 원격의 DB에 전달해주기 위해 Map에 담는 부분
        parameters.put("name",member.getName());
        parameters.put("character",member.getCharacter());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters)); // DB에 레코드를 등록
        member.setId(key.longValue());
        return member;
    }

    // 데이터를 이름으로 찾는 부분
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", ListRowMapper(), name);
        return result.stream().findAny(); // 반환이 Optinal 이므로 그것을 처리하기 위해서 사용
    }

    // 데이터 전체를 받아오는 부분
    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from testtable", ListRowMapper());
    }


    // SQL 문은 단순 결과 객체로 나오게 되는데, 이를 사용하기 위해 Map 형태로 데이터를 변환하게 해주는 역할 -> 데이터의 원활한 사용 가능
    private RowMapper<Member> ListRowMapper(){
        return ((rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setCharacter(rs.getString("character"));
            return member;
        });
    }
}
