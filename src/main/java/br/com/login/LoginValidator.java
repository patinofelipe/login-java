package br.com.login;

public class LoginValidator {

    public String validar(String usuario, String senha) {

        // Verifica se o usuário foi informado
        if (usuario == null || usuario.isBlank()) {

            return "O usuário não pode ficar vazio.";
        }


        // Verifica o formato do e-mail
        if (!validarEmail(usuario)) {

            return "Digite um e-mail válido.";
        }


        // Verifica se a senha foi informada
        if (senha == null || senha.isBlank()) {

            return "A senha não pode ficar vazia.";
        }


        // Verifica o tamanho mínimo da senha
        if (senha.length() < 6) {

            return "A senha deve possuir no mínimo 6 caracteres.";
        }


        // Nenhum erro encontrado
        return null;
    }


    private boolean validarEmail(String email) {

        return email.matches(
            "^[^\\s@]+@[^\\s@]+\\.com$"
        );
    }
}
