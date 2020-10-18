package edu.ic4302.DAO;
import java.util.List;

import edu.ic4302.model.CompraProducto;
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
public class CompraProductoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CompraProducto> listCompraProducto () {

        String sql = "SELECT * FROM COMPRA_PRODUCTO";

        List<CompraProducto> listCompraProducto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompraProducto.class));

        return listCompraProducto;
    }

    public void saveCompraProducto(CompraProducto compraProducto) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("compra_producto").usingColumns("id_compra", "id_producto", "cantidad", "precio");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compraProducto);
        insertActor.execute(param);
    }

    public CompraProducto getCompraProducto(int id) {
        String sql = "SELECT * FROM COMPRA_PRODUCTO WHERE id = ?";
        Object[] args = {id};
        CompraProducto compraProducto = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(CompraProducto.class));

        return compraProducto;
    }

    public void updateCompraProducto(CompraProducto compraProducto) {

        String sql = "UPDATE COMPRA_PRODUCTO SET id_compra=:id_compra, id_producto=:id_producto, cantidad=:cantidad, precio=:precio WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compraProducto);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteCompraProducto(int id) {
        String sql = "DELETE FROM COMPRA_PRODUCTO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
