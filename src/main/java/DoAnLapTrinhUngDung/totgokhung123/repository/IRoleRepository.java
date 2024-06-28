package DoAnLapTrinhUngDung.totgokhung123.repository;

import DoAnLapTrinhUngDung.totgokhung123.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r.id From Role r Where r.name = ?1")
    Long getRoleIdByName(String roleName);
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(String roleName);
}

