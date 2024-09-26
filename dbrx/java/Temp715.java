import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Temp715 {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public Temp715() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        Temp715 temp715 = new Temp715();
        try {
            List<Map<String, Object>> results = temp715.parameterize(List.of(1, 2, 3));
            System.out.println(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> parameterize(List<Integer> list) throws Exception {
        String b = "SELECT * FROM table_name WHERE abc IN (:value)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("value", list);
        return jdbcTemplate.queryForList(b, namedParameters);
    }

    private NamedParameterJdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }
}