package vgvr.stocksapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vgvr.stocksapp.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    @Modifying
    @Query("update User u set u.password = :pass where u.id = :id")
    void updateUser(@Param(value = "id") Long id, @Param(value = "pass") String password);
}
