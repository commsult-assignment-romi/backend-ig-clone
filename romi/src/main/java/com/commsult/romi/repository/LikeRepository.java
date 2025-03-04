package com.commsult.romi.repository;

import com.commsult.romi.model.LikeEntity;
import com.commsult.romi.model.Post;
import com.commsult.romi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    Optional<LikeEntity> findByPostAndUser(Post post, User user);
}
