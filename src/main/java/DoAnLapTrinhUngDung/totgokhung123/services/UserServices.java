package DoAnLapTrinhUngDung.totgokhung123.services;

import DoAnLapTrinhUngDung.totgokhung123.entity.User;
import DoAnLapTrinhUngDung.totgokhung123.repository.IRoleRepository;
import DoAnLapTrinhUngDung.totgokhung123.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository rolePepository;
    public void save(User user) {

        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = rolePepository.getRoleIdByName("USER");
        if(roleId != 0 && userId != 0){
            userRepository.addRoleToUser(userId,roleId);
        }
    }
}