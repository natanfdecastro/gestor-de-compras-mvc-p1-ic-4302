package edu.ic4302.DAO;

import java.util.List;

import edu.ic4302.model.Proveedor;
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
public class ProveedorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Proveedor> list() {

        String sql = "SELECT * FROM PROVEEDOR";

        List<Proveedor> listProveedor = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Proveedor.class));

        return listProveedor;
    }

    public void save(Proveedor proveedor) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Proveedor").usingColumns("nombre", "direccion", "telefono");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(proveedor);
        insertActor.execute(param);
    }

    public Proveedor get(int id) {
        String sql = "SELECT * FROM PROVEEDOR WHERE id = ?";
        Object[] args = {id};
        Proveedor proveedor = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Proveedor.class));

        return proveedor;
    }

    public void update(Proveedor proveedor) {

        String sql = "UPDATE PROVEEDOR SET nombre=:nombre, direccion=:direccion, telefono=:telefono WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(proveedor);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM PROVEEDOR WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
