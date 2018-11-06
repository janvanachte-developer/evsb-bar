package be.cm.vsb.bar.impl;

import be.cm.vsb.bar.Bar;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource()
public interface BarRepository extends JpaRepository<Bar, String> { }
