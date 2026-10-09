package br.com.login;

public class UserRepository {

    public User buscarPorEmail(String email) {

        if ("teste@email.com".equals(email)) {

            return new User(
                1L,
                "Felipe",
                "teste@email.com",
                "123456"
            );
        }

        return null;
    }
}
