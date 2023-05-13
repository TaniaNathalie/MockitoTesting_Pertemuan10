package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class UserServiceImplTest {
    UserDAO userDAO = Mockito.mock(UserDAO.class);
    SecurityService securityService = Mockito.mock(SecurityService.class);
    UserServiceImpl userServiceImpl = new UserServiceImpl(userDAO, securityService);
    User user = new User();

    //test untuk memverifikasi jika object user berhasil mendapatkan password barunya
    @Test
    public void UserObjectGetThePassword() throws Exception {
        user.setPassword("71200566");
        user.setPassword("71200566_TE");
        Mockito.when(securityService.md5("71200566_TE")).thenReturn("27aa784bab1a05256d88c247eede6c5f"); //27aa784bab1a05256d88c247eede6c5f adalah md5 dari 71200566_TE
        userServiceImpl.assignPassword(user);
        Mockito.verify(userDAO).updateUser(user);
        Assertions.assertEquals("27aa784bab1a05256d88c247eede6c5f", user.getPassword());
    }

    //test untuk memverifikasi jika method updateUser() pada userDAO dipanggil dengan benar
    @Test
    public void TestUpdateUser() throws Exception {
        user.setPassword("71200566");
        user.setPassword("71200566_TE");
        Mockito.when(securityService.md5("71200566_TE")).thenReturn("71200566_TE1");
        userServiceImpl.assignPassword(user);
        Mockito.verify(userDAO, Mockito.times(1)).updateUser(user);
    }
}
