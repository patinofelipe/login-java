package br.com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recebe os dados enviados pelo formulário
        String usuario = request.getParameter("usuario");

        String senha = request.getParameter("senha");


        // 2. Cria o objeto responsável pela validação
        LoginValidator validator = new LoginValidator();


        // 3. Valida os dados
        String erro = validator.validar(usuario, senha);


        // 4. Configura a resposta
        response.setContentType("text/html; charset=UTF-8");


        // 5. Verifica o resultado da validação
        if (erro != null) {

            response.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="pt-BR">

                    <head>
                        <meta charset="UTF-8">
                        <title>Erro no Login</title>
                    </head>

                    <body>

                        <h1>Erro de validação</h1>

                        <p>%s</p>

                        <a href="javascript:history.back()">
                            Voltar
                        </a>

                    </body>

                    </html>
                    """.formatted(erro));

            return;
        }


        // 6. Se não existe erro, os dados são válidos
        response.getWriter().println("""
                <!DOCTYPE html>
                <html lang="pt-BR">

                <head>
                    <meta charset="UTF-8">
                    <title>Login</title>
                </head>

                <body>

                    <h1>Login processado pelo Java!</h1>

                    <p>Usuário válido: %s</p>

                    <p>
                        Os dados passaram pela validação do servidor.
                    </p>

                </body>

                </html>
                """.formatted(usuario));
    }
}