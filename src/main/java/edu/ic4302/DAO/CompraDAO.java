package edu.ic4302.DAO;

import java.util.List;

import edu.ic4302.model.Compra;;
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
public class CompraDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Compra> listCompras() {

        String sql = "SELECT * FROM COMPRA";

        List<Compra> listCompra = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Compra.class));

        return listCompra;
    }

    public void saveCompra(Compra compra) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Compra").usingColumns("fecha", "id_proveedor");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compra);
        insertActor.execute(param);
    }

    public Compra getCompra(int id) {
        String sql = "SELECT * FROM COMPRA WHERE id = ?";
        Object[] args = {id};
        Compra compra = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Compra.class));

        return compra;
    }

    public void updateCompra(Compra compra) {

        String sql = "UPDATE COMPRA SET fecha=:fecha, id_proveedor=:id_proveedor WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compra);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteCompra(int id) {
        String sql = "DELETE FROM COMPRA WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
