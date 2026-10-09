package br.com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        LoginService service = new LoginService();

        String erro = service.realizarLogin(usuario, senha);

        response.setContentType("text/html; charset=UTF-8");

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

        // Cria ou recupera a sessão do usuário
        HttpSession session = request.getSession();

        // Guarda o e-mail do usuário na sessão
        session.setAttribute("usuario", usuario);

        response.getWriter().println("""
                <!DOCTYPE html>
                <html lang="pt-BR">

                <head>
                    <meta charset="UTF-8">
                    <title>Login</title>
                </head>

                <body>

                    <h1>Login realizado com sucesso!</h1>

                    <p>Usuário autenticado: %s</p>

                    <p>
                        A sessão do usuário foi criada pelo servidor.
                    </p>

                </body>

                </html>
                """.formatted(usuario));
    }
}