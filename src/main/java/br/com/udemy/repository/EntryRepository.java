package br.com.udemy.repository;

import br.com.udemy.domain.model.Entry;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntryRepository implements PanacheRepository<Entry> {
}
