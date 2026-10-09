package br.com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera a sessão existente
        HttpSession session = request.getSession(false);

        // Se não existir sessão, usuário não está autenticado
        if (session == null ||
            session.getAttribute("usuario") == null) {

            response.sendRedirect("index.html");
            return;
        }

        // Recupera o usuário armazenado na sessão
        String usuario =
                (String) session.getAttribute("usuario");

        response.setContentType("text/html; charset=UTF-8");

        response.getWriter().println("""
                <!DOCTYPE html>
                <html lang="pt-BR">

                <head>
                    <meta charset="UTF-8">
                    <title>Dashboard</title>
                </head>

                <body>

                    <h1>Dashboard</h1>

                    <p>
                        Bem-vindo, %s!
                    </p>

                    <p>
                        Você está autenticado no sistema.
                    </p>

                </body>

                </html>
                """.formatted(usuario));
    }
}