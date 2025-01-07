package GestionUsuario.MSUsuario.service;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

 
@Service
@CacheConfig(cacheNames = "access")
public class AuthService {
 
    @Autowired
    private IAuthRepository authRepository;
    
    public AccessModel save(AccessModel model) {
        return authRepository.save(model);
    }
   
    public List<AccessModel>  getAcces() {
        return authRepository.findAll();
    }
   
    public Boolean validatedCredentials(String UserName, String Password) {
        List<AccessModel> result = (List<AccessModel>) authRepository.findAll();
        List<AccessModel> resultFilter = result.stream()
                .filter(t -> t.getUsername().equals(UserName) && t.getPassword().equals(Password))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }
   
}


