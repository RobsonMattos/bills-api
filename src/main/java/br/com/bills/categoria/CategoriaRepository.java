package br.com.bills.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
