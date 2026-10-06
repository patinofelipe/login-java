javascript

console.log("LOGIN.JS NOVA VERSÃO - TESTE 123");

const form = document.getElementById("loginForm");

const usuario = document.getElementById("usuario");

const senha = document.getElementById("senha");

const usuarioErro = document.getElementById("usuarioErro");

const senhaErro = document.getElementById("senhaErro");

const mensagem = document.getElementById("mensagem");


form.addEventListener("submit", function(event) {

    // Limpa mensagens anteriores
    limparMensagens();

    let valido = true;

    const email = usuario.value.trim();

    const senhaValor = senha.value;


    // ==========================
    // VALIDAÇÃO DO E-MAIL
    // ==========================

    if (email === "") {

        usuarioErro.textContent =
            "O usuário não pode ficar vazio.";

        valido = false;

    } else if (!validarEmail(email)) {

        usuarioErro.textContent =
            "Digite um e-mail válido.";

        valido = false;
    }


    // ==========================
    // VALIDAÇÃO DA SENHA
    // ==========================

    if (senhaValor === "") {

        senhaErro.textContent =
            "A senha não pode ficar vazia.";

        valido = false;

    } else if (senhaValor.length < 6) {

        senhaErro.textContent =
            "A senha deve possuir no mínimo 6 caracteres.";

        valido = false;
    }


    // ==========================
    // RESULTADO DA VALIDAÇÃO
    // ==========================

    if (!valido) {

        // Impede o formulário de ser enviado
        event.preventDefault();

        return;
    }

    // Se chegou aqui, os dados são válidos.
    //
    // NÃO usamos event.preventDefault().
    //
    // Portanto, o navegador continuará o envio
    // do formulário para:
    //
    // action="login"
    //
    // utilizando:
    //
    // method="post"
});


function validarEmail(email) {

    const regex =
        /^[^\s@]+@[^\s@]+\.com$/;

    return regex.test(email);
}


function limparMensagens() {

    usuarioErro.textContent = "";

    senhaErro.textContent = "";

    mensagem.textContent = "";
}
