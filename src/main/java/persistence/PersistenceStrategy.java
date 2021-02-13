package persistence;


public interface PersistenceStrategy {

    void persist(int score);

    void load();

}
