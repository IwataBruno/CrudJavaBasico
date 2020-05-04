package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author iwata
 */
public class ProdutoDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Produto> lista = new ArrayList<Produto>();
    
    public ProdutoDAO(){
        
        conn = new ConnectionFactory().getConexao();
    }
    
    public void inserir(Produto produto){
        
        String sql = "INSERT INTO produtos(nome,valor) VALUES(?,?)";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Produto produto){
        
        String sql = "UPDATE produtos SET nome = ?, valor = ? WHERE id = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setInt(3, produto.getId());
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
    
    public void excluir(int valorid){
        
        String sql = "DELETE FROM produtos WHERE id="+valorid;
        
        try {
            
            st = conn.createStatement();
            st.execute(sql);
            st.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Produto> listarTodos(){
        
        String sql = "SELECT * FROM produtos";
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                lista.add(produto);
                
            }
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
        return lista;
    }
    
    public ArrayList<Produto> pesquisar(String valor){
        
        String sql = "SELECT * FROM produtos WHERE nome LIKE'%"+valor+"%'";
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                lista.add(produto);
                
        }
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
        
        return lista;
    }
}


