package br.com.login;

public class LoginService {

    private final LoginValidator validator;

    public LoginService() {
        this.validator = new LoginValidator();
    }

    public String realizarLogin(String usuario, String senha) {

        String erro = validator.validar(usuario, senha);

        if (erro != null) {
            return erro;
        }

        User user = new User(
        1L,
        "Felipe",
        usuario,
        senha
    );

    return "Usuário criado: " + user.getNome()
            + " - " + user.getEmail();
    }
}