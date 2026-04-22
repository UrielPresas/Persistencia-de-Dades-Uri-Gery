package DAO.MySQL;

import DAO.EscaladorDAO;
import Model.Escalador;

import java.util.List;

public class MySQLescaladorDAO implements EscaladorDAO {
   //private Connection conn;

    /*public MySQLescaladorDAO(Connection conn){
        this.conn = conn;
    }*/

    @Override
    public void inserir(Escalador c) {

    }

    @Override
    public void modificar(Escalador c) {

    }

    @Override
    public void eliminar(Escalador c) {

    }

    @Override
    public List<Escalador> obtindreTots() {
        return List.of();
    }

    @Override
    public Escalador obtenir(Long id) {
        return null;
    }
}
