package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.Client;
import com.G42_Proyecto.G42_Proyecto.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();

    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return clientRepository.save(c);
        } else {
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if (e.isPresent()) {
                return e.get();
            } else {
                return clientRepository.save(c);
            }
        }

    }

    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> q = clientRepository.getClient(c.getIdClient());
            if (q.isPresent()) {
                if (c.getName() != null) {
                    q.get().setName(c.getName());
                }
                if (c.getEmail() != null) {
                    q.get().setEmail(c.getName());
                }
                if (c.getPassword() != null) {
                    q.get().setPassword(c.getPassword());
                }
                if (c.getAge() != null) {
                    q.get().setAge(c.getAge());
                }

                clientRepository.save(q.get());
                return q.get();

            } else {
                return c;
            }
        } else {
            return c;
        }

    }
    
    public boolean deleteClient(int id) {
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;

    }

}
