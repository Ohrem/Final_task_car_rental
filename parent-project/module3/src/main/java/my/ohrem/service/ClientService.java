package my.ohrem.service;

import my.ohrem.dao.ClientDao;
import my.ohrem.model.Client;
import my.ohrem.model.ClientDetail;
import my.ohrem.model.ClientPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDao clientDao;

    @Transactional
    public void add(Client client, byte[] photo) {
        ClientDetail clientDetail = client.getClientDetail();
        if (clientDetail.getClient() == null) {
            client.getClientDetail().setClient(client);
        }

        if (client.getClientPhoto() == null) {
            ClientPhoto clientPhoto = new ClientPhoto();
            clientPhoto.setClient(client);
            clientPhoto.setPhoto(photo);
            client.setClientPhoto(clientPhoto);
        }
        clientDao.create(client);
    }

    public List<Client> getAll() {
        return clientDao.findAll();
    }

    public Client getById(long clientId) {
        return clientDao.findById(clientId);
    }
}

