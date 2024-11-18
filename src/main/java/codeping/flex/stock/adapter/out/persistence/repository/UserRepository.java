package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
