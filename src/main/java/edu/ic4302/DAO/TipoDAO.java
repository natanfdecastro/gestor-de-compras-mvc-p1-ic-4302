package edu.ic4302.DAO;

import java.util.List;

import edu.ic4302.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TipoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tipo> listTipo() {

        String sql = "SELECT * FROM TIPO";

        List<Tipo> listTipo = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tipo.class));

        return listTipo;
    }

    public void saveTipo(Tipo tipo) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Tipo").usingColumns("nombre");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tipo);
        insertActor.execute(param);
    }

    public Tipo getTipo(int id) {
        String sql = "SELECT * FROM TIPO WHERE id = ?";
        Object[] args = {id};
        Tipo tipo = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Tipo.class));

        return tipo;
    }

    public void updateTipo(Tipo tipo) {

        String sql = "UPDATE TIPO SET nombre=:nombre WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteTipo(int id) {
        String sql = "DELETE FROM TIPO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
