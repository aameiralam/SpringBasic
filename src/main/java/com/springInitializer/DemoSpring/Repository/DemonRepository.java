package com.springInitializer.DemoSpring.Repository;

import com.springInitializer.DemoSpring.Entity.Demon;
import org.springframework.data.repository.ListCrudRepository;

public interface DemonRepository extends ListCrudRepository<Demon, Long> {
}
