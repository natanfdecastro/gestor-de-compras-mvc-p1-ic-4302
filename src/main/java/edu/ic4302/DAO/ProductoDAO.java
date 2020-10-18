package edu.ic4302.DAO;
import java.util.List;

import edu.ic4302.model.Producto;
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
public class ProductoDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Producto> listProductos() {

        String sql = "SELECT * FROM PRODUCTO";

        List<Producto> listProducto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Producto.class));

        return listProducto;
    }


    public void saveProducto(Producto producto) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Producto").usingColumns("nombre", "medida", "id_tipo");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(producto);
        insertActor.execute(param);
    }

    public Producto getProducto(int id) {
        String sql = "SELECT * FROM PRODUCTO WHERE id = ?";
        Object[] args = {id};
        Producto producto = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Producto.class));

        return producto;
    }

    public void updateProducto(Producto producto) {

        String sql = "UPDATE PRODUCTO SET nombre=:nombre, medida=:medida, id_tipo=:id_tipo WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(producto);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteProducto(int id) {
        String sql = "DELETE FROM PRODUCTO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }



}