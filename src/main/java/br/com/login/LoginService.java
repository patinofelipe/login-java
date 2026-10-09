package br.com.login;

public class LoginService {

    private final LoginValidator validator;
    private final UserRepository repository;

    public LoginService() {

        this.validator = new LoginValidator();
        this.repository = new UserRepository();
    }

    public String realizarLogin(String usuario, String senha) {

        // 1. Valida os dados recebidos
        String erro = validator.validar(usuario, senha);

        if (erro != null) {
            return erro;
        }

        // 2. Procura o usuário pelo e-mail
        User user = repository.buscarPorEmail(usuario);

        // 3. Verifica se o usuário existe
        if (user == null) {
            return "Usuário não encontrado.";
        }

        // 4. Verifica a senha
        if (!user.getSenha().equals(senha)) {
            return "Senha incorreta.";
        }

        // 5. Login realizado com sucesso
        System.out.println(
            "Login realizado: "
            + user.getNome()
            + " - "
            + user.getEmail()
        );

        // null significa que não houve erro
        return null;
    }
}
