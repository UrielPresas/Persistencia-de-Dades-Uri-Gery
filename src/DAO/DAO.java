package DAO;

import java.util.List;

// T == Tipus d'objecte (Candidat, Via, Sector...)
// K == Tipus de clau primaria (Long, String, int, Float...)
public interface DAO<T, K>{
    void inserir(T c);
    void modificar(T c);
    void eliminar(T c);
    List<T> obtindreTots();
    T obtenir(K id);
}
