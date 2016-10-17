package com.sfeir.sfeircarto.neo4j.service;


import com.sfeir.sfeircarto.neo4j.domain.Person;
import com.sfeir.sfeircarto.neo4j.repository.PersonRepository;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubio.d on 12/10/2016.
 */
@Service
@Transactional
public class Neo4jService {

    @Inject
    private Session session;

    @Inject
    private PersonRepository personRepository;

    /**
     * Check nodes in DB.
     */
    public List<Person> getAllPersons() throws UnsupportedOperationException {
        return personRepository.findAll();
    }

    public void cleanDb() {
        session.purgeDatabase();
    }

    /**
     convert InputStream to String
     * @param is
     * @return
     */
    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
