package cl.bci.pruebatecnica.repository;

import cl.bci.pruebatecnica.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
