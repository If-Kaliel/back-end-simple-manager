package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.Connection;

public class GenericAdminDAO implements AutoCloseable {
    protected Connection conn;

    public GenericAdminDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    // Esse método resolve o erro [ERROR] try-with-resources not applicable
    @Override
    public void close() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}