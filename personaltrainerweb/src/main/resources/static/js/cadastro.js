document.getElementById("cadastroForm").addEventListener("submit", function (event) {
    event.preventDefault();

    // Captura os dados do formulário
    const nome = document.getElementById("nome").value;
    const usuario = document.getElementById("usuario").value;
    const senha = document.getElementById("senha").value;

    // Cria um objeto com os dados do formulário
    const usuarioCadastro = {
        nome: nome,
        usuario: usuario,
        senha: senha
    };

    // Envia uma requisição POST para o backend
    fetch("/usuarios/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuarioCadastro)
    })
    .then(response => {
        // Verifica se a resposta é OK (código 200)
        if (response.ok) {
            return response.json();
        } else {
            // Tratar resposta com erro de usuário já existente
            return response.json().then(err => {
                throw new Error(err.message || "Erro ao cadastrar o usuário");
            });
        }
    })
    .then(data => {
        // Exibe mensagem de sucesso ou redireciona
        document.getElementById("mensagemCadastro").textContent = "Usuário cadastrado com sucesso!";
        document.getElementById("mensagemCadastro").classList.remove("erro");

        // Redireciona para outra página 
        setTimeout(() => {
            window.location.href = "/index";
        }, 1000);
    })
    .catch(error => {
        document.getElementById("mensagemCadastro").textContent = error.message;
        document.getElementById("mensagemCadastro").classList.add("erro");
    });
});