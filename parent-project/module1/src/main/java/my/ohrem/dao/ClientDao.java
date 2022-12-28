package my.ohrem.dao;

import my.ohrem.model.Client;

import java.util.List;

public interface ClientDao {

    void create(Client client);

    Client findById(long id);

    void update(Client client);

    void delete(Client client);

    List<Client> findAll();
}
