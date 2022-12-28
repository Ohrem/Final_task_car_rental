package my.ohrem.dao;

import my.ohrem.model.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Client client) {
        sessionFactory.getCurrentSession().saveOrUpdate(client);
    }

    @Override
    public Client findById(long id) {
        return sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public void update(Client client) {
        create(client);
    }

    @Override
    public void delete(Client client) {
        Client loadedClient = sessionFactory.getCurrentSession().load(Client.class, client.getId());
        sessionFactory.getCurrentSession().delete(loadedClient);
    }

    @Override
    public List<Client> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).list();
    }
}

