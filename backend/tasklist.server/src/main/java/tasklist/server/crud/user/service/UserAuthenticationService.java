package tasklist.server.crud.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tasklist.server.core.exception.ValidationException;
import tasklist.server.core.utils.EncryptionUtil;
import tasklist.server.model.user.Credentials;
import tasklist.server.model.user.TokenDTO;
import tasklist.server.model.user.UserEntity;

/**
 * Serviço que autentica os usuarios do sistema.
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Service
public class UserAuthenticationService {

    @Autowired
    private UserQueryService userQueryService;

    /**
     * Autentica o usuario com as credenciais recebidas, gerando um {@link UserTokenEntity} e retornando o mesmo.
     * @param credentials - {@link Credentials}
     * @return TokenDTO
     */
    @Transactional(rollbackFor = Throwable.class)
    public TokenDTO authenticateUser(Credentials credentials) throws Exception{
        if (existUser(credentials)) {
            TokenDTO tokenDTO = new TokenDTO();
            String username = credentials.getUsername();
			tokenDTO.setToken(generateToken(username, credentials.getPassword()));
            tokenDTO.setUsername(username);
			return tokenDTO;
        }
        throw new ValidationException("Login ou senha incorretos.");
    }

    private boolean existUser(Credentials credentials) {
        UserEntity userByUsername = userQueryService.getUserByUsername(credentials.getUsername());
        return userByUsername != null && userByUsername.getPassword().equalsIgnoreCase(credentials.getPassword());
    }

    /**
     * Valida o token, verificando se
     * @param token - {@link String}
     * @return Boolean
     */
    @Transactional(rollbackFor = Throwable.class)
    public Boolean validToken(String token) throws ValidationException {
//        List<UserActivityEntity> activities = userActivityQueryService.getActivities(userTokenEntity);
//        activities.sort((o1, o2) -> CompareUtils.compare(o1.getDateTime(), o2.getDateTime()));
//        UserActivityEntity lastUserActivity = activities.get(activities.size()-1);
//
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime last = lastUserActivity.getDateTime();
//        Long diff = last.until(now, ChronoUnit.MINUTES);
//        // the last activity has between larger 15 minutes, then generate new token
//        if (diff > 15) {
//            return false;
//        }
        return true;
    }

    /**
     * Retorna o token gerado com base no login e senha.
     * @param username - {@link String}
     * @param password - {@link String}
     * @throws Exception
     */
    public String generateToken(String username, String password) throws Exception {
    	return EncryptionUtil.encodeMD5(username+"#"+password);
    }
}